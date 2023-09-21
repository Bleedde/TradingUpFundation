import { Component } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import { CreateUserServiceService } from '../../service/create-user-service.service';
import { GenericResponse } from '../../service/response/GenericResponse';
import { UserDomain } from './domains/UserDomain';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent {

  userForm!: FormGroup;
  userDomain!: UserDomain;


  constructor(public formulary: FormBuilder, private createUserServiceService: CreateUserServiceService){
    this.userForm = formulary.group({
      name : ['', [Validators.required]],
      email : ['', [Validators.required]],
      password : ['', [Validators.required]],
      level : ['', [Validators.required]],
      status : ['', [Validators.required]],
      backtesting : ['', [Validators.required]],
      auditedAccount : ['', [Validators.required]]
    });
  } 

  createUser(){

    this.userDomain = {
      id: 0,
      name: this.userForm.controls['name'].value,
      email: this.userForm.controls['email'].value,
      password: this.userForm.controls['password'].value,
      userLevel: this.userForm.controls['level'].value,
      status: this.userForm.controls['status'].value,
      backtesting: this.userForm.controls['backtesting'].value,
      auditedAccount: this.userForm.controls['auditedAccount'].value
    }

    this.createUserServiceService.createUserService(this.userDomain).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)
        alert("Registrado Exitosamente, Bienvenido a TradingUpFundation")
      }
    )
  }

  onSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Formulario válido. Datos enviados:', form.value);
      // Aquí puedes agregar código adicional para enviar los datos al servidor o realizar otras acciones.
    } else {
      console.log('Formulario no válido. Por favor, complete los campos requeridos correctamente.');
    }
  }



}
