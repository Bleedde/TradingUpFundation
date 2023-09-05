import { Component } from '@angular/core';

@Component({
  selector: 'app-curso-admin-page',
  templateUrl: './curso-admin-page.component.html',
  styleUrls: ['./curso-admin-page.component.scss']
})
export class CursoAdminPageComponent {

  sectionUser!: boolean;
  sectionContent!: boolean;
  slideDatos!: boolean;

  modalActivate(datos: boolean) {
    this.sectionUser = datos;
    this.slideDatos = false;
  }

  slideActivate(datos:boolean){
    this.slideDatos = datos;
  }
}
