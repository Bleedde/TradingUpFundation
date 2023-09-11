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


@NgModule({
  declarations: [
    CursoAdminPageComponent,
    SlideVarComponent,
    HeaderComponent,
    UsuariosComponent,
    ContenidoCursoComponent,
    LibrosComponent,
    StartAComponent
  ],
  imports: [
    CommonModule,
    CursosAdminRoutingModule
  ]
})
export class CursosAdminModule { }
