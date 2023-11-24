import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CursosAdminRoutingModule } from './cursos-admin-routing.module';
import { CursoAdminPageComponent } from './curso-admin-page/curso-admin-page.component';
import { UsuariosComponent } from './curso-admin-page/components/usuarios/usuarios.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CompartidoModule } from '../compartido/compartido.module';
import { CreateUserServiceService } from '../service/userServices/create-user-service.service';
import { ReadUsersServiceService } from '../service/userServices/read-users-service.service';
import { UpdateUsersServiceService } from '../service/userServices/update-users-service.service';
import { DeleteUserServiceService } from '../service/userServices/delete-user-service.service';

@NgModule({
  declarations: [
    CursoAdminPageComponent,
    UsuariosComponent
  ],
  imports: [
    CommonModule,
    CursosAdminRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    CompartidoModule
  ],
  providers: [
    CreateUserServiceService,
    ReadUsersServiceService,
    UpdateUsersServiceService,
    DeleteUserServiceService
  ],
  exports:[

  ]
})
export class CursosAdminModule { }