import { Component } from '@angular/core';

@Component({
  selector: 'app-curso-admin-page',
  templateUrl: './curso-admin-page.component.html',
  styleUrls: ['./curso-admin-page.component.scss']
})
export class CursoAdminPageComponent {

  sectionUser!: boolean;
  sectionContent!: boolean;
  sectionBook!: boolean;
  slideDatos!: boolean;

  modalActivateUser(datos: boolean) {
    this.sectionContent = false;
    this.sectionUser = datos;
    this.sectionBook = false;
    console.log("brahian esta aqui" + "", datos)
  }

  modalActivateContent(datos:boolean){
    this.sectionUser = false;
    this.sectionContent = datos;
    this.sectionBook = false;
    console.log("brahian esta aqui" + "", datos)
  }

  modalActivateBook(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = datos;
    this.sectionContent = false;
    console.log("brahian esta aqui" + "", datos)
  }

  slideActivate(datos:boolean){
    this.slideDatos = datos;
  }
}
