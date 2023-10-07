import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CursosAdminRoutingModule } from './cursos-admin-routing.module';
import { CursoAdminPageComponent } from './curso-admin-page/curso-admin-page.component';
import { SlideVarComponent } from './curso-admin-page/components/slide-var/slide-var.component';
import { HeaderComponent } from './curso-admin-page/components/header/header.component';
import { UsuariosComponent } from './curso-admin-page/components/usuarios/usuarios.component';
import { ContenidoCursoComponent } from './curso-admin-page/components/contenido-curso/contenido-curso.component';
import { LibrosComponent } from './curso-admin-page/components/libros/libros.component';
import { StartAComponent } from './curso-admin-page/components/start-a/start-a.component';
import { EjerciciosClaseComponent } from './curso-admin-page/components/ejercicios-clase/ejercicios-clase.component';
import { ClasesGrabadasComponent } from './curso-admin-page/components/clases-grabadas/clases-grabadas.component';
import { ClasesPregrabadasComponent } from './curso-admin-page/components/clases-pregrabadas/clases-pregrabadas.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateUserServiceService } from './curso-admin-page/service/userServices/create-user-service.service';
import { ReadUsersServiceService } from './curso-admin-page/service/userServices/read-users-service.service';
import { UpdateUsersServiceService } from './curso-admin-page/service/userServices/update-users-service.service';
import { DeleteUserServiceService } from './curso-admin-page/service/userServices/delete-user-service.service';

@NgModule({
  declarations: [
    CursoAdminPageComponent,
    SlideVarComponent,
    HeaderComponent,
    UsuariosComponent,
    ContenidoCursoComponent,
    LibrosComponent,
    StartAComponent,
    EjerciciosClaseComponent,
    ClasesGrabadasComponent,
    ClasesPregrabadasComponent
  ],
  imports: [
    CommonModule,
    CursosAdminRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    CreateUserServiceService,
    ReadUsersServiceService,
    UpdateUsersServiceService,
    DeleteUserServiceService
  ]
})
export class CursosAdminModule { }