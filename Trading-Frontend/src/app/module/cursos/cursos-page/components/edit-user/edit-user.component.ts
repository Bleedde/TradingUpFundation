import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserDomain } from 'src/app/shared/domains/UserDomain';

import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserServiceService } from 'src/app/module/service/userServices/read-user-service.service';
import { UpdateUsersServiceService } from 'src/app/module/service/userServices/update-users-service.service';

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
    private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService ){
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
