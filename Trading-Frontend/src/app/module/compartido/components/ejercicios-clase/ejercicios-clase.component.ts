import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { CreateExerciseServiceService } from 'src/app/module/service/exercises/create-exercise-service.service';
import { DeleteExerciseServiceService } from 'src/app/module/service/exercises/delete-exercise-service.service';
import { ReadExercisesServiceService } from 'src/app/module/service/exercises/read-exercises-service.service';
import { UpdateExerciseServiceService } from 'src/app/module/service/exercises/update-exercise-service.service';
import { BOOK1, GRAFICEXERCISE } from 'src/app/shared/constants';
import { ExerciseDomain } from 'src/app/shared/domains/ExerciseDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-ejercicios-clase',
  templateUrl: './ejercicios-clase.component.html',
  styleUrls: ['./ejercicios-clase.component.scss']
})
export class EjerciciosClaseComponent {
  graficExercise = GRAFICEXERCISE;

  exerciseForm!: FormGroup;
  exerciseDomain!: ExerciseDomain;
  listExerciseDomain: ExerciseDomain[] = [];
  editExerciseDomain!: boolean;
  id!: number;

  ejerciciosClase!: boolean;
  mensaje!: boolean;

  niveles: { value: string; label: string }[] = [
    { value: '1', label: 'Nivel 1' },
    { value: '2', label: 'Nivel 2' },
    { value: '3', label: 'Nivel 3' },
    { value: '4', label: 'Nivel 4' },
  ];
  nivelSeleccionado: string = '1';

  private valoresInicialesFormulario: any;

  exercise!: ExerciseDomain;

  constructor(public formulary: FormBuilder, private CreateExerciseServiceService: CreateExerciseServiceService, private ReadExercisesServiceService: ReadExercisesServiceService, private UpdateExerciseServiceService: UpdateExerciseServiceService, private DeleteExerciseServiceService: DeleteExerciseServiceService, private compartidoServiceService: CompartidoServiceService) {

    this.ejerciciosClase = this.compartidoServiceService.getData();
    this.mensaje = this.compartidoServiceService.getData();

    this.exerciseForm = formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      dataStart: ['', [Validators.required]],
      dataEnd: ['', [Validators.required]],
      level: [0, [Validators.required]],
      file: [null, [Validators.required]]
    })
  }


  ngOnInit(): void {

    this.exerciseForm = this.formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      dataStart: ['', [Validators.required]],
      dataEnd: ['', [Validators.required]],
      level: [this.nivelSeleccionado],
      file: ['', [Validators.required]]
    });

    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.exerciseForm.value;
  }

  createExercise() {
    if (!this.exerciseForm.valid) {
      return this.exerciseForm.markAllAsTouched();
    } else {
      const formData = new FormData();
  
      // Agregar id con valor predeterminado de 0
      formData.append('id', '24');
      formData.append('title', this.exerciseForm.get('title')?.value || '');
      formData.append('description', this.exerciseForm.get('description')?.value || '');
      formData.append('dataStart', this.exerciseForm.get('dataStart')?.value || '');
      formData.append('dataEnd', this.exerciseForm.get('dataEnd')?.value || '');
  
      const selectedLevel = this.exerciseForm.get('level')?.value || '1';
      formData.append('level', selectedLevel);
  
      const fileInput = this.exerciseForm.get('file');
      if (fileInput instanceof FormControl) {
        // Obtén el archivo directamente del campo del formulario
        const file: File | null = fileInput.value;
        if (file) {
          // Asegúrate de que el tercer parámetro sea el nombre del archivo
          const blob = new Blob([file], { type: file.type });
          // Usa la instancia de formData ya creada
          formData.append('file', blob, file.name);
        }
      }
  
      // Agregar console.log para imprimir los datos antes de la llamada al servicio
      console.log('Datos a enviar:');
      formData.forEach((value, key) => {
        console.log(`${key}: ${value}`);
      });
  
      this.CreateExerciseServiceService.createExerciseService(formData).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message);
          if (res.httpResponse == 200) {
          }
        }
      );
    }
  }
  


  /*createExercise() {

    if (!this.exerciseForm.valid) {
      return this.exerciseForm.markAllAsTouched()
    }
    else {
      this.exerciseDomain = {
        id: 0,
        title: this.exerciseForm.controls['title'].value,
        description: this.exerciseForm.controls['description'].value,
        dataStart: this.exerciseForm.controls['dataStart'].value,
        dataEnd: this.exerciseForm.controls['dataEnd'].value,
        level: this.exerciseForm.controls['level'].value != 0
          ? this.exerciseForm.controls['level'].value
          : 1,
        file: this.exerciseForm.controls['file'].value
      }

      console.log("prueba de class" + this.exerciseDomain.file)

      this.CreateExerciseServiceService.createExerciseService(this.exerciseDomain).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message)
          if (res.httpResponse == 200) {
            window.location.reload()
          }
        }
      )
    }
  }*/

  readExercisesService() {
    this.ReadExercisesServiceService.readClassesService().subscribe(
      (res: GenericResponse) => {
        for (let exerciseItem of res.objectResponse) {
          this.listExerciseDomain.push(exerciseItem);
        }
      }
    )
  }

  editExercise(i: number) {
    this.editExerciseDomain = true;
    this.id = i;
    this.exercise = this.listExerciseDomain[this.id];

    console.log(this.exercise);
    // Configura el valor inicial de nivelSeleccionado y estadoSeleccionado
    this.nivelSeleccionado = this.exercise.level.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.exerciseForm.patchValue({
      classPrerecordedLevel: this.nivelSeleccionado
    });
  }

  updateExercise() {
    this.exercise = {
      id: this.listExerciseDomain[this.id].id,
      title: this.exerciseForm.controls['title'].value != ''
        ? this.exerciseForm.controls['title'].value
        : this.listExerciseDomain[this.id].title,
      description: this.exerciseForm.controls['description'].value != ''
        ? this.exerciseForm.controls['description'].value
        : this.listExerciseDomain[this.id].description,
      dataStart: this.exerciseForm.controls['dataStart'].value != ''
        ? this.exerciseForm.controls['dataStart'].value
        : this.listExerciseDomain[this.id].dataStart,
      dataEnd: this.exerciseForm.controls['dataEnd'].value != ''
        ? this.exerciseForm.controls['dataEnd'].value
        : this.listExerciseDomain[this.id].dataEnd,
      level: this.exerciseForm.controls['level'].value != null
        ? this.exerciseForm.controls['level'].value
        : this.listExerciseDomain[this.id].level,
      file: this.exerciseForm.controls['file'].value != ''
        ? this.exerciseForm.controls['file'].value
        : this.listExerciseDomain[this.id].file
    }

    this.UpdateExerciseServiceService.updateClassService(this.exercise).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)
        console.log(res.httpResponse)
        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }

  deleteExercise(i: number) {
    this.DeleteExerciseServiceService.deleteExerciseService(this.listExerciseDomain[i].id).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }


  cancelarEdicion() {
    this.editExerciseDomain = false;
    // Restablecer el formulario a los valores iniciales guardados
    this.exerciseForm.setValue(this.valoresInicialesFormulario);
  }

}

