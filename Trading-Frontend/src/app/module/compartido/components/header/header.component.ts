import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { Route, Router, RouterLink } from '@angular/router';
import { RoutCursosGuardianService } from 'src/app/guardian/cursosGuardian/rout-cursos-guardian.service';
import { RoutGuardianService } from 'src/app/guardian/rout-guardian.service';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { IMAGEN_LOGO } from 'src/app/shared/constants';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnChanges {

  ngOnChanges(changes: SimpleChanges): void {
    console.log("cambio efectuado " + changes['datosEditUser1'])
    this.datosEditUser = this.datosEditUser1;
  }

  @Input() datosEditUser1!: boolean;

  @Output() activateSlideVar = new EventEmitter<boolean>();
  @Output() activateSectionEditUser = new EventEmitter<boolean>();


  datosSlide = true;
  datosEditUser = false;
  logo = IMAGEN_LOGO; 

  userEdit!: boolean;

  constructor(private compartidoServiceService:CompartidoServiceService, private routGuardianService: RoutGuardianService, private RoutCursosGuardianService: RoutCursosGuardianService, private router: Router, private datosUserServiceService: DatosUserServiceService){
    this.userEdit = this.compartidoServiceService.getData();
  }
  
  cerrarSesion(){
    console.log("entre al metodo cerrar sesion")
    this.routGuardianService.generalAccessTokenRemove();
    this.RoutCursosGuardianService.cursosAccessTokenRemove();
    this.datosUserServiceService.userIdAccessTokenRemove();
    this.router.navigate(['/login-page']);
  }

  clickSlide(){
    this.activateSlideVar.emit(this.datosSlide = !this.datosSlide);
  
  }
  
  clickSectionEditUser(){
    this.activateSectionEditUser.emit(this.datosEditUser = !this.datosEditUser);
  }
}
