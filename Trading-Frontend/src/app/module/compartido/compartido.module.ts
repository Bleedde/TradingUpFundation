import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { SlideVarComponent } from './components/slide-var/slide-var.component';
import { StartAComponent } from './components/start-a/start-a.component';



@NgModule({
  declarations: [
    HeaderComponent,
    SlideVarComponent,
    StartAComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    HeaderComponent,
    SlideVarComponent,
    StartAComponent
  ]
})
export class CompartidoModule { }
