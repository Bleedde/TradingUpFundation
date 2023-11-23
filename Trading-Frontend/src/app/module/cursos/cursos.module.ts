import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosRoutingModule } from './cursos-routing.module';
import { CursosPageComponent } from './cursos-page/cursos-page.component';
import { UsuariosComponent } from '../cursos-admin/curso-admin-page/components/usuarios/usuarios.component';
import { CursosAdminModule } from '../cursos-admin/cursos-admin.module';
import { CompartidoModule } from '../compartido/compartido.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    CursosPageComponent
  ],
  imports: [
    CommonModule,
    CursosRoutingModule,
    CompartidoModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
})
export class CursosModule { }
