import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { SlideVarComponent } from './components/slide-var/slide-var.component';
import { StartAComponent } from './components/start-a/start-a.component';
import { ClasesGrabadasComponent } from './components/clases-grabadas/clases-grabadas.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ClasesPregrabadasComponent } from './components/clases-pregrabadas/clases-pregrabadas.component';
import { LibrosComponent } from './components/libros/libros.component';
import { EjerciciosClaseComponent } from './components/ejercicios-clase/ejercicios-clase.component';
import { EditUserComponent } from './components/edit-user/edit-user/edit-user.component';




@NgModule({
  declarations: [
    HeaderComponent,
    SlideVarComponent,
    StartAComponent,
    ClasesGrabadasComponent,
    ClasesPregrabadasComponent,
    LibrosComponent,
    EjerciciosClaseComponent,
    EditUserComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  exports:[
    HeaderComponent,
    SlideVarComponent,
    StartAComponent,
    ClasesGrabadasComponent,
    ClasesPregrabadasComponent,
    LibrosComponent,
    EjerciciosClaseComponent,
    EditUserComponent
  ]
})
export class CompartidoModule { }
