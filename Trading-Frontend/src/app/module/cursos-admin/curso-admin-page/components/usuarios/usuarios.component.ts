import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';
import { CreateUserServiceService } from '../../service/create-user-service.service';
import { DeleteUserServiceService } from '../../service/delete-user-service.service';
import { ReadUsersServiceService } from '../../service/read-users-service.service';
import { GenericResponse } from '../../service/response/GenericResponse';
import { UpdateUsersServiceService } from '../../service/update-users-service.service';
import { UserDomain } from './domains/UserDomain';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit{

  userForm!: FormGroup;
  userDomain!: UserDomain;
  listUserDomain: UserDomain [] = [];
  editUserDomain!: boolean;
  id!: number;
  
  user!: UserDomain;


  constructor(public formulary: FormBuilder, private createUserServiceService: CreateUserServiceService, 
    private readUsersServiceService: ReadUsersServiceService, private updateUserService: UpdateUsersServiceService, 
    private deleteUserServiceService: DeleteUserServiceService ){
    this.userForm = formulary.group({
      name : ['', [Validators.required]],
      email : ['', [Validators.required]],
      password : ['', [Validators.required]],
      level : [[Validators.required]],
      status : [[Validators.required]],
      backtesting : ['', [Validators.required]],
      auditedAccount : ['', [Validators.required]]
    });
  } 

  ngOnInit(): void {
    this.readUsersService();
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
      auditedAccount: this.userForm.controls['auditedAccount'].value,
      userRole : this.userForm.controls['userRole'].value
    }

    this.createUserServiceService.createUserService(this.userDomain).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)
        if(res.httpResponse == 200){
          window.location.reload()
        }
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

  readUsersService(){
    this.readUsersServiceService.readUsersService().subscribe(
      (res: GenericResponse) => {
        for(let userItem of res.objectResponse){
          this.listUserDomain.push(userItem);
        }
      }
    )
  }

  editUser(i: number){
    this.editUserDomain = true;
    this.id = i;
    this.user = this.listUserDomain[this.id];
  }

  updateUser(){
    this.user = {
      id : this.listUserDomain[this.id].id,
      name : this.userForm.controls['name'].value != ''
        ? this.userForm.controls['name'].value
        : this.listUserDomain[this.id].name,
      email :  this.userForm.controls['email'].value != ''
        ? this.userForm.controls['email'].value
        : this.listUserDomain[this.id].email,
      password :  this.userForm.controls['password'].value != ''
        ? this.userForm.controls['password'].value
        : this.listUserDomain[this.id].password,
      userLevel :  this.userForm.controls['level'].value != null
        ? this.userForm.controls['level'].value
        : this.listUserDomain[this.id].userLevel,
      status :  this.userForm.controls['status'].value != null
        ? this.userForm.controls['status'].value
        : this.listUserDomain[this.id].status,
      backtesting :  this.userForm.controls['backtesting'].value != ''
        ? this.userForm.controls['backtesting'].value
        : this.listUserDomain[this.id].backtesting,
      auditedAccount :  this.userForm.controls['auditedAccount'].value != ''
        ? this.userForm.controls['auditedAccount'].value
        : this.listUserDomain[this.id].auditedAccount,
      userRole :  this.userForm.controls['userRole'].value != ''
        ? this.userForm.controls['userRole'].value
        : this.listUserDomain[this.id].userRole,
    }

    this.updateUserService.updateUserService(this.user).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if(res.httpResponse == 200){
          window.location.reload()
        }
      }
    )
  }

  deleteUser(i: number){
    this.deleteUserServiceService.deleteUserService(this.listUserDomain[i]).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if(res.httpResponse == 200){
          window.location.reload()
        }
      }
    )
  }





}
