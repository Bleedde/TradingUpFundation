import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { IMAGEN_LOGO } from 'src/app/shared/constants';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  @Output() activateSlideVar = new EventEmitter<boolean>();
  @Output() activateSectionEditUser = new EventEmitter<boolean>();


  datosSlide = true;
  datosEditUser = false;
  logo = IMAGEN_LOGO; 

  userEdit!: boolean;

  constructor(private compartidoServiceService:CompartidoServiceService){
    this.userEdit = this.compartidoServiceService.getData();
  }
  



  clickSlide(){
    this.activateSlideVar.emit(this.datosSlide = !this.datosSlide);
  
  }



  clickSectionEditUser(){
    this.activateSectionEditUser.emit(this.datosEditUser = !this.datosEditUser);
  }
}
