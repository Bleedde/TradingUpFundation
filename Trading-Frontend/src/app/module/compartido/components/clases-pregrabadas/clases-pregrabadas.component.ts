import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { CreatePrerecordedServiceService } from 'src/app/module/service/prerecordedClassServices/create-prerecorded-service.service';
import { DeletePrerecordedServiceService } from 'src/app/module/service/prerecordedClassServices/delete-prerecorded-service.service';
import { ReadPrerecordedsServiceService } from 'src/app/module/service/prerecordedClassServices/read-prerecordeds-service.service';
import { UpdatePrerecordedServiceService } from 'src/app/module/service/prerecordedClassServices/update-prerecorded-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';
import { Alerts } from 'src/app/shared/alerts/alerts';
import { ClassPrerecordedDomain } from 'src/app/shared/domains/ClassPrerecordedDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-clases-pregrabadas',
  templateUrl: './clases-pregrabadas.component.html',
  styleUrls: ['./clases-pregrabadas.component.scss']
})
export class ClasesPregrabadasComponent {
  private alerts: Alerts = new Alerts();
  youtubeVideo: String = 'https://www.youtube.com/embed/';

  safeUrl: SafeResourceUrl | undefined; // Variable para la URL segura
  classPrerecordedForm!: FormGroup;
  classPrerecordedDomain!: ClassPrerecordedDomain;
  listClassPrerecordedDomain: ClassPrerecordedDomain [] = [];
  editClassPrerecordedDomain!: boolean;
  id!: number;

  buttonValue!: number
  userToEdit: { userLevel: number } = { userLevel: 0 };
  availableLevels = [1, 2, 3, 4]; 
  selectedLevel: number | undefined;

  buttonClicked(level: number) {
    this.selectedLevel = level; // Almacena el valor de level en la variable selectedLevel
    this.readClassesPrerecordedService(this.selectedLevel);
  }

  clasesPregrabadas!: boolean;
  mensaje!: boolean;

  niveles: { value: string; label: string }[] = [
    { value: '1', label: 'Nivel 1' },
    { value: '2', label: 'Nivel 2' },
    { value: '3', label: 'Nivel 3' },
    { value: '4', label: 'Nivel 4' },
  ];
  nivelSeleccionado: string = '1';

  private valoresInicialesFormulario: any;

  classPrerecorded!: ClassPrerecordedDomain;

  constructor(public formulary: FormBuilder, private createPrerecordedServiceService: CreatePrerecordedServiceService,private readPrerecordedsServiceService: ReadPrerecordedsServiceService ,private updatePrerecordedServiceService: UpdatePrerecordedServiceService, private deletePrerecordedServiceService: DeletePrerecordedServiceService, private sanitizer: DomSanitizer, private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService){

    this.clasesPregrabadas = this.compartidoServiceService.getData();
    this.mensaje = this.compartidoServiceService.getData();

    this.classPrerecordedForm = formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      level: [0, [Validators.required]],
      urlVideo: ['', [Validators.required]],
    })
  }


  ngOnInit(): void {

    this.classPrerecordedForm = this.formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      level: [this.nivelSeleccionado],
      urlVideo: ['', [Validators.required]],
    });

    this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.classPrerecordedForm.controls['urlVideo'].value);
    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.classPrerecordedForm.value;

    this.readUserLevel();
  }

  createClassPrerecorded() {

    if (!this.classPrerecordedForm.valid) {
      return this.classPrerecordedForm.markAllAsTouched()
    }
    else {

      const urlVideo = this.classPrerecordedForm.controls['urlVideo'].value;
      // Marcar la URL como segura
      this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(urlVideo);

      this.classPrerecordedDomain = {
        id: 0,
        title: this.classPrerecordedForm.controls['title'].value,
        description: this.classPrerecordedForm.controls['description'].value,
        level: this.classPrerecordedForm.controls['level'].value != 0
          ? this.classPrerecordedForm.controls['level'].value
          : 1,
        urlVideo: this.classPrerecordedForm.controls['urlVideo'].value
      }

      console.log("prueba de class" + this.classPrerecordedDomain)

      this.createPrerecordedServiceService.createClassPrerecordedService(this.classPrerecordedDomain).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message)
          if (res.httpResponse == 200) {
            this.alerts.showModalCreated();
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

  readClassesPrerecordedService(level: number) {
    this.listClassPrerecordedDomain = [];
  
    this.readPrerecordedsServiceService.readClassesPrerecordedService(level).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200 && Array.isArray(res.objectResponse) && res.objectResponse.length > 0) {
          for (const classPrerecordedItem of res.objectResponse) {
            const url = classPrerecordedItem.urlVideo;
            classPrerecordedItem.urlVideo = this.youtubeVideo + url;
            const safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(classPrerecordedItem.urlVideo);
            classPrerecordedItem.urlVideo = safeUrl;
            this.listClassPrerecordedDomain.push(classPrerecordedItem);
          }
        } else {
          this.alerts.showModalPrerecorded();
        }
      },
      (error) => {
        console.error('Error al enviar el formulario:', error);
      }
    );
  }
  

  editClassPrerecorded(i: number) {
    this.editClassPrerecordedDomain = true;
    this.id = i;
    this.classPrerecorded = this.listClassPrerecordedDomain[this.id];
    
    console.log(this.classPrerecorded);
    // Configura el valor inicial de nivelSeleccionado y estadoSeleccionado
    this.nivelSeleccionado = this.classPrerecorded.level.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.classPrerecordedForm.patchValue({
      level: this.nivelSeleccionado
    });
  }

  updateClassPrerecorded() {
    this.classPrerecorded = {
      id: this.listClassPrerecordedDomain[this.id].id,
      title: this.classPrerecordedForm.controls['title'].value != ''
        ? this.classPrerecordedForm.controls['title'].value
        : this.listClassPrerecordedDomain[this.id].title,
      description: this.classPrerecordedForm.controls['description'].value != ''
        ? this.classPrerecordedForm.controls['description'].value
        : this.listClassPrerecordedDomain[this.id].description,
      level: this.classPrerecordedForm.controls['level'].value != null
        ? this.classPrerecordedForm.controls['level'].value
        : this.listClassPrerecordedDomain[this.id].level,
      urlVideo: this.classPrerecordedForm.controls['urlVideo'].value != ''
        ? this.classPrerecordedForm.controls['urlVideo'].value
        : this.listClassPrerecordedDomain[this.id].urlVideo
    }

    this.updatePrerecordedServiceService.updateClassPrerecordedService(this.classPrerecorded).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)
        console.log(res.httpResponse)
        if (res.httpResponse == 200) {
          this.alerts.showModalUpdated();
        }
      }
    )
  }

  deleteClassPrerecorded(i: number) {
    this.deletePrerecordedServiceService.deleteClassPrerecordedService(this.listClassPrerecordedDomain[i].id).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          this.alerts.showModalDelete();  
        }
      }
    )
  }


  cancelarEdicion() {
    this.editClassPrerecordedDomain = false;

    // Restablecer el formulario a los valores iniciales guardados
    this.classPrerecordedForm.setValue(this.valoresInicialesFormulario);
  }
}
