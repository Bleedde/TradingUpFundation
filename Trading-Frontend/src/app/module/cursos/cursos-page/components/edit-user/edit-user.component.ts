import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserDomain } from 'src/app/module/cursos-admin/curso-admin-page/components/usuarios/domains/UserDomain';
import { GenericResponse } from 'src/app/module/cursos-admin/curso-admin-page/service/response/GenericResponse';
import { ReadUserServiceService } from 'src/app/module/cursos-admin/curso-admin-page/service/userServices/read-user-service.service';
import { UpdateUsersServiceService } from 'src/app/module/cursos-admin/curso-admin-page/service/userServices/update-users-service.service';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';

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

  constructor(public formulary: FormBuilder,
    private readUserServiceService: ReadUserServiceService, private updateUserService: UpdateUsersServiceService, 
    private compartidoServiceService: CompartidoServiceService ){
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
    this.readUserServiceService.readUserService(1).subscribe(
      (res: GenericResponse) => {
        this.user = res.objectResponse;
      }
    )
  }


  updateUser(){
    
  }
}
