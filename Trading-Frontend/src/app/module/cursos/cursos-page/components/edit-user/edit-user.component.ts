import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserDomain } from 'src/app/shared/domains/UserDomain';

import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserServiceService } from 'src/app/module/service/userServices/read-user-service.service';
import { UpdateUsersServiceService } from 'src/app/module/service/userServices/update-users-service.service';
import { ReadUserEmailService } from 'src/app/module/service/userServices/read-user-email.service';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

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

  constructor(public formulary: FormBuilder, private updateUserService: UpdateUsersServiceService, private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserEmailService: ReadUserEmailService ){
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
    const userEmail = this.datosUserServiceService.getUserEmail(); // Recupera el email del localStorage

  if (userEmail) {
    this.readUserEmailService.readUserEmail(userEmail).subscribe(
      (response: GenericResponse) => {
        if (response) {
          if (response.httpResponse === 200) {
            const userToEdit = response.objectResponse;

            // Llena el formulario con los datos del usuario recuperados
            this.userForm.patchValue({
              name: userToEdit.name,
              email: userToEdit.email,
              password: userToEdit.password,
              level: userToEdit.userLevel,
              status: userToEdit.status,
              backtesting: userToEdit.backtesting,
              auditedAccount: userToEdit.auditedAccount
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

  datosUser(){
    
  }

  updateUser(){
    
  }
}
