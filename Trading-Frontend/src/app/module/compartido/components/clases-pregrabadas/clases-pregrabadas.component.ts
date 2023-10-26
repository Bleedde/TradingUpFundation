import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { CreatePrerecordedServiceService } from 'src/app/module/service/prerecordedClassServices/create-prerecorded-service.service';
import { DeletePrerecordedServiceService } from 'src/app/module/service/prerecordedClassServices/delete-prerecorded-service.service';
import { ReadPrerecordedsServiceService } from 'src/app/module/service/prerecordedClassServices/read-prerecordeds-service.service';
import { UpdatePrerecordedServiceService } from 'src/app/module/service/prerecordedClassServices/update-prerecorded-service.service';
import { ClassPrerecordedDomain } from 'src/app/shared/domains/ClassPrerecordedDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-clases-pregrabadas',
  templateUrl: './clases-pregrabadas.component.html',
  styleUrls: ['./clases-pregrabadas.component.scss']
})
export class ClasesPregrabadasComponent {
  youtubeVideo: String = 'https://www.youtube.com/embed/';

  safeUrl: SafeResourceUrl | undefined; // Variable para la URL segura
  classPrerecordedForm!: FormGroup;
  classPrerecordedDomain!: ClassPrerecordedDomain;
  listClassPrerecordedDomain: ClassPrerecordedDomain [] = [];
  editClassPrerecordedDomain!: boolean;
  id!: number;

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

  constructor(public formulary: FormBuilder, private createPrerecordedServiceService: CreatePrerecordedServiceService,private readPrerecordedsServiceService: ReadPrerecordedsServiceService ,private updatePrerecordedServiceService: UpdatePrerecordedServiceService, private deletePrerecordedServiceService: DeletePrerecordedServiceService, private sanitizer: DomSanitizer, private compartidoServiceService: CompartidoServiceService){

    this.clasesPregrabadas = this.compartidoServiceService.getData();
    this.mensaje = this.compartidoServiceService.getData();

    this.classPrerecordedForm = formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      classPrerecordedLevel: [0, [Validators.required]],
      urlVideo: ['', [Validators.required]],
    })
  }


  ngOnInit(): void {

    this.classPrerecordedForm = this.formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      classPrerecordedLevel: [this.nivelSeleccionado],
      urlVideo: ['', [Validators.required]],
    });

    this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.classPrerecordedForm.controls['urlVideo'].value);
    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.classPrerecordedForm.value;

    this.readClassesPrerecordedService();
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
        classPrerecordedLevel: this.classPrerecordedForm.controls['classPrerecordedLevel'].value != 0
          ? this.classPrerecordedForm.controls['classPrerecordedLevel'].value
          : 1,
        urlVideo: this.classPrerecordedForm.controls['urlVideo'].value
      }

      console.log("prueba de class" + this.classPrerecordedDomain)

      this.createPrerecordedServiceService.createClassPrerecordedService(this.classPrerecordedDomain).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message)
          if (res.httpResponse == 200) {
            window.location.reload()
          }
        }
      )
    }
  }

  readClassesPrerecordedService() {
    this.readPrerecordedsServiceService.readClassesPrerecordedService().subscribe(
      (res: GenericResponse) => {
        for (let classPrerecordedItem of res.objectResponse) {
          let url = classPrerecordedItem.urlVideo;
          classPrerecordedItem.urlVideo = this.youtubeVideo + url;
          this.safeUrl = this.sanitizer.bypassSecurityTrustResourceUrl(classPrerecordedItem.urlVideo);
          classPrerecordedItem.urlVideo = this.safeUrl;
          this.listClassPrerecordedDomain.push(classPrerecordedItem);
        }
      }
    )
  }

  editClassPrerecorded(i: number) {
    this.editClassPrerecordedDomain = true;
    this.id = i;
    this.classPrerecorded = this.listClassPrerecordedDomain[this.id];
    
    console.log(this.classPrerecorded);
    // Configura el valor inicial de nivelSeleccionado y estadoSeleccionado
    this.nivelSeleccionado = this.classPrerecorded.classPrerecordedLevel.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.classPrerecordedForm.patchValue({
      classPrerecordedLevel: this.nivelSeleccionado
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
      classPrerecordedLevel: this.classPrerecordedForm.controls['classPrerecordedLevel'].value != null
        ? this.classPrerecordedForm.controls['classPrerecordedLevel'].value
        : this.listClassPrerecordedDomain[this.id].classPrerecordedLevel,
      urlVideo: this.classPrerecordedForm.controls['urlVideo'].value != ''
        ? this.classPrerecordedForm.controls['urlVideo'].value
        : this.listClassPrerecordedDomain[this.id].urlVideo
    }

    this.updatePrerecordedServiceService.updateClassPrerecordedService(this.classPrerecorded).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)
        console.log(res.httpResponse)
        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }

  deleteClassPrerecorded(i: number) {
    this.deletePrerecordedServiceService.deleteClassPrerecordedService(this.listClassPrerecordedDomain[i].id).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          window.location.reload()
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
