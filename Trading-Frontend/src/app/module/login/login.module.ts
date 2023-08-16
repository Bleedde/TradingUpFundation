import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginPageComponent } from './login-page/login-page.component';
import { LoginComponent } from './login-page/components/login/login.component';


@NgModule({
  declarations: [
    LoginPageComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    LoginRoutingModule
  ]
})
export class LoginModule { }
