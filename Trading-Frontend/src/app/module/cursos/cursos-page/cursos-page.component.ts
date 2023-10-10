import { Component} from '@angular/core';
import { Location } from '@angular/common';
import { CompartidoServiceService } from '../../service/compartido-service.service';
import { UserDomain } from '../../cursos-admin/curso-admin-page/components/usuarios/domains/UserDomain';


@Component({
  selector: 'app-cursos-page',
  templateUrl: './cursos-page.component.html',
  styleUrls: ['./cursos-page.component.scss']
})
export class CursosPageComponent{

  
  sectionUser!: boolean;
  sectionContent!: boolean;
  sectionBook!: boolean;
  sectionExercises!: boolean;
  sectionClass!: boolean;
  sectionPrerecorded!: boolean;
  sectionEditUser!: boolean;

  slideDatos: boolean = true;
  startA = true;
  datosPrueba!: boolean;

  modalActivateUser(datos: boolean) {
    this.sectionContent = false;
    this.sectionUser = datos;
    this.sectionBook = false;
    this.sectionClass = false;
    this.sectionPrerecorded = false;
    this,this.startA = false;
    this.sectionExercises = false;
    console.log("Prueba del user: " + !datos)

  }

  modalActivateContent(datos:boolean){
    this.sectionUser = false;
    this.sectionContent = datos;
    this.sectionBook = false;
    this.sectionClass = false;
    this.sectionPrerecorded = false;
    this,this.startA = false;
    this.sectionExercises = false;
  }

  modalActivateBook(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = datos;
    this.sectionContent = false;
    this.sectionClass = false;
    this.sectionPrerecorded = false;
    this.startA = false;
    this.sectionExercises = false;
    
  }

  modalActivateExercises(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = false;
    this.sectionContent = false;
    this.sectionClass = false;
    this.sectionPrerecorded = false;
    this.startA = false;
    this.sectionExercises = datos;
  }

  modalActivateClasses(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = false;
    this.sectionContent = false;
    this.sectionClass = datos;
    this.sectionPrerecorded = false;
    this.startA = false;
    this.sectionExercises = false;
  }

  modalActivatePrerecordeds(datos:boolean){
    this.sectionUser = false;
    this.sectionBook = false;
    this.sectionContent = false;
    this.sectionClass = false;
    this.sectionPrerecorded = datos;
    this.startA = false;
    this.sectionExercises = false;
  }

  slideActivate(datos:boolean){
    console.log("prueba " + this.datosPrueba)
    this.slideDatos = datos;
    this.datosPrueba = !datos;
    console.log("parametro " + datos)
    console.log("datos prueba: " + this.datosPrueba);
  }

  // CursosPage

  modalActivateEditUser(datos:boolean){
    this.startA = false;
    this.sectionEditUser = datos;
  }


  

  constructor(private compartidoServiceService: CompartidoServiceService){
    let userModel: UserDomain;
    userModel = this.compartidoServiceService.getData();

    const currentUrl = window.location.href;
    console.log('URL exacta:', currentUrl);
    if(currentUrl == "http://localhost:4200/cursos-page")
    {
      this.compartidoServiceService.setData(true)
    }
    

  }

}
