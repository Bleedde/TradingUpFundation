import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CursosRoutingModule } from './cursos-routing.module';
import { CursosPageComponent } from './cursos-page/cursos-page.component';
import { HeaderComponent } from './cursos-page/components/header/header.component';
import { SlideVarComponent } from './cursos-page/components/slide-var/slide-var.component';


@NgModule({
  declarations: [
    CursosPageComponent,
    HeaderComponent,
    SlideVarComponent
  ],
  imports: [
    CommonModule,
    CursosRoutingModule
  ]
})
export class CursosModule { }
