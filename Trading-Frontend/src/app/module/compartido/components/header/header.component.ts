import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Route, Router, RouterLink } from '@angular/router';
import { RoutCursosGuardianService } from 'src/app/guardian/cursosGuardian/rout-cursos-guardian.service';
import { RoutGuardianService } from 'src/app/guardian/rout-guardian.service';
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

  constructor(private compartidoServiceService:CompartidoServiceService, private routGuardianService: RoutGuardianService, private RoutCursosGuardianService: RoutCursosGuardianService, private router: Router){
    this.userEdit = this.compartidoServiceService.getData();
  }
  
  cerrarSesion(){
    console.log("entre al metodo cerrar sesion")
    this.routGuardianService.generalAccessTokenRemove();
    this.RoutCursosGuardianService.cursosAccessTokenRemove();
    this.router.navigate(['/login-page']);
  }

  clickSlide(){
    this.activateSlideVar.emit(this.datosSlide = !this.datosSlide);
  
  }
  
  clickSectionEditUser(){
    this.activateSectionEditUser.emit(this.datosEditUser = !this.datosEditUser);
  }
}