import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { IMAGEN_LOGO } from 'src/app/shared/constants';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  
  
  @Input() datos1!:boolean;
  
  @Output() activateSlideVar = new EventEmitter<boolean>();
  datos = false;
  logo = IMAGEN_LOGO; 

  
  clickSlide(){
    this.activateSlideVar.emit(this.datos = !this.datos);
    console.log("brahian esta aqui " + this.datos)
  }

}
