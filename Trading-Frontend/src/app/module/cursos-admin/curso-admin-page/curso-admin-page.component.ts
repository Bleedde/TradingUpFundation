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
  sectionExercises!: boolean;
  slideDatos: boolean = true;
  startA = true;
  datosPrueba!: boolean;

  modalActivateUser(datos: boolean) {
    this.sectionContent = false;
    this.sectionUser = datos;
    this.sectionBook = false;
    this,this.startA = false;
    this.sectionExercises = false;
    console.log("Prueba del user: " + !datos)
  }

  modalActivateContent(datos:boolean){
    this.sectionUser = false;
    this.sectionContent = datos;
    this.sectionBook = false;
    this,this.startA = false;
    this.sectionExercises = false;
  }

  modalActivateBook(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = datos;
    this.sectionContent = false;
    this.startA = false;
    this.sectionExercises = false;
    
  }

  modalActivateExercises(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = false;
    this.sectionContent = false;
    this.startA = false;
    this.sectionExercises = datos;
  }

  slideActivate(datos:boolean){
    console.log("prueba " + this.datosPrueba)
    this.slideDatos = datos;
    this.datosPrueba = !datos;
    console.log("parametro " + datos)
    console.log("datos prueba: " + this.datosPrueba);
  }
}
