import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';


import { UserDomain } from './domains/UserDomain';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { ReadUsersServiceService } from 'src/app/module/service/userServices/read-users-service.service';
import { CreateUserServiceService } from 'src/app/module/service/userServices/create-user-service.service';
import { DeleteUserServiceService } from 'src/app/module/service/userServices/delete-user-service.service';
import { UpdateUsersServiceService } from 'src/app/module/service/userServices/update-users-service.service';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';


@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  userForm!: FormGroup;
  userDomain!: UserDomain;
  listUserDomain: UserDomain[] = [];
  editUserDomain!: boolean;
  id!: number;

  niveles: { value: string; label: string }[] = [
    { value: '1', label: 'Nivel 1' },
    { value: '2', label: 'Nivel 2' },
    { value: '3', label: 'Nivel 3' },
    { value: '4', label: 'Nivel 4' },
  ];
  nivelSeleccionado: string = '1';

  estados: { value: string; label: string }[] = [
    { value: 'true', label: 'Activo' },
    { value: 'false', label: 'Inactivo' },
  ];
  estadoSeleccionado: string = 'true';

  private valoresInicialesFormulario: any;

  user!: UserDomain;


  constructor(public formulary: FormBuilder, private createUserServiceService: CreateUserServiceService,
    private readUsersServiceService: ReadUsersServiceService, private updateUserService: UpdateUsersServiceService,
    private deleteUserServiceService: DeleteUserServiceService, private compartidoServiceService: CompartidoServiceService) {
    this.userForm = formulary.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.nullValidator]],
      level: [0, [Validators.required]],
      status: [[Validators.required]],
      backtesting: ['', Validators.nullValidator],
      auditedAccount: ['', Validators.nullValidator]
    });
  }

  ngOnInit(): void {

    this.userForm = this.formulary.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      level: [this.nivelSeleccionado],
      status: [this.estadoSeleccionado],
      backtesting: ['', Validators.nullValidator],
      auditedAccount: ['', Validators.nullValidator]
      // Nivel seleccionado por defecto
    });

    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.userForm.value;


    this.readUsersService();
  }

  createUser() {

    if (!this.userForm.valid) {
      return this.userForm.markAllAsTouched()
    }
    else {
      this.userDomain = {
        id: 0,
        name: this.userForm.controls['name'].value,
        email: this.userForm.controls['email'].value,
        password: this.userForm.controls['password'].value,
        userLevel: this.userForm.controls['level'].value != 0
          ? this.userForm.controls['level'].value
          : 1,
        status: this.userForm.controls['status'].value,
        backtesting: this.userForm.controls['backtesting'].value,
        auditedAccount: this.userForm.controls['auditedAccount'].value,
        userRole: 'user'
      }

      this.createUserServiceService.createUserService(this.userDomain).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message)
          if (res.httpResponse == 200) {
            window.location.reload()
          }
        }
      )
    }
  }

  /*onSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Formulario válido. Datos enviados:', form.value);
      // Aquí puedes agregar código adicional para enviar los datos al servidor o realizar otras acciones.
    } else {
      console.log('Formulario no válido. Por favor, complete los campos requeridos correctamente.');
    }
  }*/

  readUsersService() {
    this.readUsersServiceService.readUsersService().subscribe(
      (res: GenericResponse) => {
        for (let userItem of res.objectResponse) {
          this.listUserDomain.push(userItem);
        }
      }
    )
  }

  editUser(i: number) {
    this.editUserDomain = true;
    this.id = i;
    this.user = this.listUserDomain[this.id];

    console.log(this.user)
    // Configura el valor inicial de nivelSeleccionado y estadoSeleccionado
    this.nivelSeleccionado = this.user.userLevel.toString();
    this.estadoSeleccionado = this.user.status.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.userForm.patchValue({
      level: this.nivelSeleccionado,
      status: this.estadoSeleccionado
    });
  }



  updateUser() {
    this.user = {
      id: this.listUserDomain[this.id].id,
      name: this.userForm.controls['name'].value != ''
        ? this.userForm.controls['name'].value
        : this.listUserDomain[this.id].name,
      email: this.userForm.controls['email'].value != ''
        ? this.userForm.controls['email'].value
        : this.listUserDomain[this.id].email,
      password: this.userForm.controls['password'].value != ''
        ? this.userForm.controls['password'].value
        : this.listUserDomain[this.id].password,
      userLevel: this.userForm.controls['level'].value != null
        ? this.userForm.controls['level'].value
        : this.listUserDomain[this.id].userLevel,
      status: this.userForm.controls['status'].value != null
        ? this.userForm.controls['status'].value
        : this.listUserDomain[this.id].status,
      backtesting: this.userForm.controls['backtesting'].value != ''
        ? this.userForm.controls['backtesting'].value
        : this.listUserDomain[this.id].backtesting,
      auditedAccount: this.userForm.controls['auditedAccount'].value != ''
        ? this.userForm.controls['auditedAccount'].value
        : this.listUserDomain[this.id].auditedAccount,
      userRole: 'user'
    }

    this.updateUserService.updateUserService(this.user).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }

  cancelarEdicion() {
    this.editUserDomain = false;

    // Restablecer el formulario a los valores iniciales guardados
    this.userForm.setValue(this.valoresInicialesFormulario);
  }

  deleteUser(i: number) {
    this.deleteUserServiceService.deleteUserService(this.listUserDomain[i]).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }





}
