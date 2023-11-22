import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserDomain } from 'src/app/shared/domains/UserDomain';

import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserServiceService } from 'src/app/module/service/userServices/read-user-service.service';
import { UpdateUsersServiceService } from 'src/app/module/service/userServices/update-users-service.service';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  userForm!: FormGroup;
  editUserDomain!: boolean;
  id!: number;


  user!: UserDomain;

  constructor(public formulary: FormBuilder, private updateUserService: UpdateUsersServiceService, private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService ){
    this.userForm = formulary.group({
      name : ['', [Validators.required]],
      email : ['', [Validators.required, Validators.email]],
      password : ['', [Validators.required, Validators.nullValidator]],
      level : [0, [Validators.required]],
      status : [[Validators.required]],
      backtesting : ['', Validators.nullValidator],
      auditedAccount : ['', Validators.nullValidator]
    });
  } 

  ngOnInit(): void {
    const userId = this.datosUserServiceService.getUserId(); // Recupera el email del localStorage

  if (userId) {
    this.readUserIdService.readUserId(userId).subscribe(
      (response: GenericResponse) => {
        if (response) {
          if (response.httpResponse === 200) {
            this.user = response.objectResponse;
            // Llena el formulario con los datos del usuario recuperados
            this.userForm.patchValue({
              name: this.user.name,
              password: this.user.password,
              email: this.user.email,
              level: this.user.userLevel,
              status: this.user.status,
              backtesting: this.user.backtesting,
              auditedAccount: this.user.auditedAccount,
            });
          } else {
            console.error("El servidor respondió con un error:", response.message);
          }
        } else {
          console.error("Respuesta del servidor vacía o no válida");
        }
      },
      (error) => {
        console.error("Error al obtener los datos del usuario por email:", error);
      }
    );
  } else {
    console.error("No se encontró un email en el localStorage");
  }

    console.log("leer usuario:" + this.compartidoServiceService.getData())
    this.readDataUser();
  }


  readDataUser(){
    this.user = this.compartidoServiceService.getData();
  }

  updateUser(){
    // Obtén los valores del formulario
  const updatedUser: UserDomain = {
    id: this.id,
    name: this.userForm.get('name')?.value || this.user.name, // Utiliza el valor del formulario si se proporciona, de lo contrario, usa el valor actual
    email: this.user.email, // Mantén el correo electrónico sin cambios
    password: this.userForm.get('password')?.value || this.user.password, // Utiliza el valor del formulario si se proporciona, de lo contrario, usa el valor actual
    userLevel: this.user.userLevel, // Mantén el nivel del usuario sin cambios
    status: this.userForm.get('status')?.value || this.user.status, // Utiliza el valor del formulario si se proporciona, de lo contrario, usa el valor actual
    backtesting: this.userForm.get('backtesting')?.value || this.user.backtesting, // Utiliza el valor del formulario si se proporciona, de lo contrario, usa el valor actual
    auditedAccount: this.userForm.get('auditedAccount')?.value || this.user.auditedAccount, // Utiliza el valor del formulario si se proporciona, de lo contrario, usa el valor actual
    userRole: this.user.userRole, // Mantén el rol de usuario sin cambios
  };

  // Envía la solicitud de actualización al servidor
  this.updateUserService.updateUserService(updatedUser).subscribe(
    (response: GenericResponse) => {
      if (response) {
        if (response.httpResponse === 200) {
          console.log("Usuario actualizado con éxito" + response.httpResponse)
          window.location.reload();
        } else {
          console.error("El servidor respondió con un error:", response.message);
        }
      } else {
        console.error("Respuesta del servidor vacía o no válida");
      }
    },
    (error) => {
      console.error("Error al actualizar el usuario:", error);
    }
  );
}
}
