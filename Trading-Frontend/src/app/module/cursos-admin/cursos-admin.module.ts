import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosAdminRoutingModule } from './cursos-admin-routing.module';
import { CursoAdminPageComponent } from './curso-admin-page/curso-admin-page.component';
import { SlideVarComponent } from './curso-admin-page/components/slide-var/slide-var.component';
import { HeaderComponent } from './curso-admin-page/components/header/header.component';


@NgModule({
  declarations: [
    CursoAdminPageComponent,
    SlideVarComponent,
    HeaderComponent
  ],
  imports: [
    CommonModule,
    CursosAdminRoutingModule
  ]
})
export class CursosAdminModule { }
