import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { SlideVarComponent } from './components/slide-var/slide-var.component';
import { StartAComponent } from './components/start-a/start-a.component';
import { ClasesGrabadasComponent } from './components/clases-grabadas/clases-grabadas.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ClasesPregrabadasComponent } from './components/clases-pregrabadas/clases-pregrabadas.component';



@NgModule({
  declarations: [
    HeaderComponent,
    SlideVarComponent,
    StartAComponent,
    ClasesGrabadasComponent,
    ClasesPregrabadasComponent
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
    ClasesPregrabadasComponent
  ]
})
export class CompartidoModule { }
