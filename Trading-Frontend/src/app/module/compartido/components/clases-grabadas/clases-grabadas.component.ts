import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { CreateClassServiceService } from 'src/app/module/service/classServices/create-class-service.service';
import { DeleteClassServiceService } from 'src/app/module/service/classServices/delete-class-service.service';
import { ReadClassesServiceService } from 'src/app/module/service/classServices/read-classes-service.service';
import { UpdateClassServiceService } from 'src/app/module/service/classServices/update-class-service.service';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';
import { ClassDomain } from 'src/app/shared/domains/ClassDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-clases-grabadas',
  templateUrl: './clases-grabadas.component.html',
  styleUrls: ['./clases-grabadas.component.scss']
})
export class ClasesGrabadasComponent implements OnInit {
  youtubeVideo: String = 'https://www.youtube.com/embed/';

  safeUrl: SafeResourceUrl | undefined; // Variable para la URL segura
  classForm!: FormGroup;
  classDomain!: ClassDomain;
  listClassDomain: ClassDomain[] = [];
  editClassDomain!: boolean;
  id!: number;
  buttonValue!: number
  userToEdit: { userLevel: number } = { userLevel: 0 };
  availableLevels = [1, 2, 3, 4]; 
  selectedLevel: number | undefined;

  buttonClicked(level: number) {
    this.selectedLevel = level; // Almacena el valor de level en la variable selectedLevel
    this.readClassesService(this.selectedLevel);
  }
  
  

  clasesGrabadas!: boolean;
  mensaje!: boolean;

  niveles: { value: string; label: string }[] = [
    { value: '1', label: 'Nivel 1' },
    { value: '2', label: 'Nivel 2' },
    { value: '3', label: 'Nivel 3' },
    { value: '4', label: 'Nivel 4' },
  ];
  nivelSeleccionado: string = '1';

  private valoresInicialesFormulario: any;

  class!: ClassDomain;

  constructor(public formulary: FormBuilder, private createClassServiceService: CreateClassServiceService, private readClassesServiceService: ReadClassesServiceService, private updateClassServiceService: UpdateClassServiceService, private deleteClassServiceService: DeleteClassServiceService, private sanitizer: DomSanitizer, private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService) {

    this.clasesGrabadas = this.compartidoServiceService.getData();
    this.mensaje = this.compartidoServiceService.getData();

    this.classForm = formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      classLevel: [0, [Validators.required]],
      urlVideo: ['', [Validators.required]],
    });
    // Marcar una URL como segura antes de usarla en tu plantilla
  }

  ngOnInit(): void {

    this.classForm = this.formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      classLevel: [this.nivelSeleccionado],
      urlVideo: ['', [Validators.required]],
    });

    this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.classForm.controls['urlVideo'].value);
    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.classForm.value;

    this.readUserLevel();
  }

  createClass() {
    if (!this.classForm.valid) {
      return this.classForm.markAllAsTouched()
    }
    else {

      const urlVideo = this.classForm.controls['urlVideo'].value;
      // Marcar la URL como segura
      this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(urlVideo);

      this.classDomain = {
        id: 0,
        title: this.classForm.controls['title'].value,
        description: this.classForm.controls['description'].value,
        classLevel: this.classForm.controls['classLevel'].value != 0
          ? this.classForm.controls['classLevel'].value
          : 1,
        urlVideo: this.classForm.controls['urlVideo'].value
      }

      console.log("prueba de class" + this.classDomain.classLevel)

      this.createClassServiceService.createClassService(this.classDomain).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message)
          if (res.httpResponse == 200) {
            window.location.reload()
          }
        }
      )
    }
  }

  readUserLevel() {
    const userId = this.datosUserServiceService.getUserId();
    this.readUserIdService.readUserId(userId!).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200) {
          this.userToEdit = res.objectResponse;
          console.log(this.userToEdit.userLevel);
        }
      }
    );
  }

  readClassesService(level: number) {
    this.listClassDomain = [] 
    this.readClassesServiceService.readClassesforLevelService(level).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200 && res.objectResponse.length > 0){
          for (let classItem of res.objectResponse) {
            let url = classItem.urlVideo;
            classItem.urlVideo = this.youtubeVideo + url;
            this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(classItem.urlVideo);
            classItem.urlVideo = this.safeUrl;
            this.listClassDomain.push(classItem);
          }
        }else{
          alert('No hay clases grabadas');
        }
      },
      (error) => {
        console.error('Error al enviar el formulario:', error);
      }
    )
  }

  editClass(i: number) {
    this.editClassDomain = true;
    this.id = i;
    this.class = this.listClassDomain[this.id];

    console.log(this.class);
    // Configura el valor inicial de nivelSeleccionado y estadoSeleccionado
    this.nivelSeleccionado = this.class.classLevel.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.classForm.patchValue({
      classLevel: this.nivelSeleccionado
    });
  }

  updateClass() {
    this.class = {
      id: this.listClassDomain[this.id].id,
      title: this.classForm.controls['title'].value != ''
        ? this.classForm.controls['title'].value
        : this.listClassDomain[this.id].title,
      description: this.classForm.controls['description'].value != ''
        ? this.classForm.controls['description'].value
        : this.listClassDomain[this.id].description,
      classLevel: this.classForm.controls['classLevel'].value != null
        ? this.classForm.controls['classLevel'].value
        : this.listClassDomain[this.id].classLevel,
      urlVideo: this.classForm.controls['urlVideo'].value != ''
        ? this.classForm.controls['urlVideo'].value
        : this.listClassDomain[this.id].urlVideo,

    }

    this.updateClassServiceService.updateClassService(this.class).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)
        console.log(res.httpResponse)
        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }

  deleteClass(i: number) {
    this.deleteClassServiceService.deleteClassService(this.listClassDomain[i].id).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }


  cancelarEdicion() {
    this.editClassDomain = false;

    // Restablecer el formulario a los valores iniciales guardados
    this.classForm.setValue(this.valoresInicialesFormulario);
  }
}
