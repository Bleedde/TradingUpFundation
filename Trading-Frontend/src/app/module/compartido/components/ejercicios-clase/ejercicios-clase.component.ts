import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { CreateExerciseServiceService } from 'src/app/module/service/exercises/create-exercise-service.service';
import { DeleteExerciseServiceService } from 'src/app/module/service/exercises/delete-exercise-service.service';
import { ReadExercisesServiceService } from 'src/app/module/service/exercises/read-exercises-service.service';
import { ReadFileExerciseService } from 'src/app/module/service/exercises/read-file-exercise.service';
import { UpdateExerciseServiceService } from 'src/app/module/service/exercises/update-exercise-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';
import { BOOK1, GRAFICEXERCISE } from 'src/app/shared/constants';
import { ExerciseDomain } from 'src/app/shared/domains/ExerciseDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-ejercicios-clase',
  templateUrl: './ejercicios-clase.component.html',
  styleUrls: ['./ejercicios-clase.component.scss']
})
export class EjerciciosClaseComponent implements OnInit{
  graficExercise = GRAFICEXERCISE;
  fileNameVariable!: string;
  fileType!: string;
  fileToUpload: File | null = null;
  exerciseForm!: FormGroup;
  exerciseDomain!: ExerciseDomain;
  listExerciseDomain: ExerciseDomain[] = [];
  exerciseIds: ExerciseDomain[] = [];
  editExerciseDomain!: boolean;
  id!: number;
  exerciseId!: number;

  buttonValue!: number
  userToEdit: { userLevel: number } = { userLevel: 0 };
  availableLevels = [1, 2, 3, 4]; 
  selectedLevel: number | undefined;

  buttonClicked(level: number) {
    this.selectedLevel = level; // Almacena el valor de level en la variable selectedLevel
    this.readExercisesService(this.selectedLevel);
  }


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

  constructor(public formulary: FormBuilder, private createExerciseServiceService: CreateExerciseServiceService, private readExercisesServiceService: ReadExercisesServiceService, private updateExerciseServiceService: UpdateExerciseServiceService, private deleteExerciseServiceService: DeleteExerciseServiceService, private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService, private readFileExerciseService: ReadFileExerciseService) {

    this.ejerciciosClase = this.compartidoServiceService.getData();
    this.mensaje = this.compartidoServiceService.getData();

    this.exerciseForm = formulary.group({
      title: ['', [Validators.required]],
      description: ['', [Validators.required]],
      dataStart: ['', [Validators.required]],
      dataEnd: ['', [Validators.required]],
      level: [0, [Validators.required]],
      file: [[Validators.required]]
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
    this.readUserLevel();
  }


  
  handleInputEvent(event: any) {
    const fileInput = event.target.files[0]; // Obtén el archivo seleccionado por el usuario
    if (fileInput) {
      this.fileNameVariable = fileInput.name;
      this.fileType = fileInput.type; // Guarda el nombre real del archivo en la variable
      this.fileToUpload = fileInput;
      const formData = new FormData();
      formData.append('file', fileInput); // Agrega el archivo al objeto FormData
      // Puedes hacer más acciones con el archivo aquí si es necesario
      console.log(`Archivo seleccionado: ${this.fileNameVariable}`);
      console.log(`Tipo de archivo: ${this.fileType}`);
      console.log(`Archivo a subir: ${this.fileToUpload}`);
    } else {
      console.log('Ningún archivo seleccionado.');
    }
  }
  
  

  createExercise() {
    if (!this.exerciseForm.valid) {
      return this.exerciseForm.markAllAsTouched();
    } else {
      const formData = new FormData();
      // Agrega los demás campos de formulario
      formData.append('id', '6');
      formData.append('title', this.exerciseForm.get('title')?.value || '');
      formData.append('description', this.exerciseForm.get('description')?.value || '');
      formData.append('dataStart', this.exerciseForm.get('dataStart')?.value || '');
      formData.append('dataEnd', this.exerciseForm.get('dataEnd')?.value || '');
      const selectedLevel = this.exerciseForm.get('level')?.value || '1';
      formData.append('level', selectedLevel);
      const fileInput = this.exerciseForm.get('file');
      if (fileInput instanceof FormControl) {
        const file: File | null = fileInput.value;
        if (file) {
          const blob = new Blob([this.fileToUpload!], { type: this.fileType });
          formData.append('file', this.fileToUpload!, this.fileNameVariable); // Usa el nombre real del archivo
        }
      }
      // Imprime los datos antes de la llamada al servicio
      console.log('Datos a enviar:');
      formData.forEach((value, key) => {
        console.log(`${key}: ${value}`);
      });
      // Llama al servicio para enviar los datos al backend
      this.createExerciseServiceService.createExerciseService(formData).subscribe(
        (res: GenericResponse) => {
          console.log('Respuesta del servidor: ' + res.message);
          if (res.httpResponse === 200) {
            window.location.reload();
            // Realiza acciones adicionales si es necesario
          }
        },
        (error) => {
          console.error('Error al enviar el formulario:', error);
        }
      );
    }
  }

  readUserLevel() {
    const userId = this.datosUserServiceService.getUserId();
    this.readUserIdService.readUserId(userId!).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200) {
          this.userToEdit = res.objectResponse;
          console.log('nivel del usuario ' + this.userToEdit.userLevel);
        }
      }
    );
  }

  readFileExercise(id: number) {
    this.readFileExerciseService.readFileService(id).subscribe(
      (res: GenericResponse) => {
        console.log(res.objectResponse.file); // Puedes ajustar esto según la respuesta del servicio
      },
      (error) => {
        console.error('Error al leer el ejercicio:', error);
      }
    );
  }
  

  readExercisesService(level: number) {
    this.listExerciseDomain = [];
    this.exerciseIds = [];  // Create an array to store exercise IDs
  
    this.readExercisesServiceService.readExercisesService(level).subscribe(
      (res: GenericResponse) => {
        for (let exerciseItem of res.objectResponse) {
          this.listExerciseDomain.push(exerciseItem);
          this.exerciseIds.push(exerciseItem.id);
          this.exerciseId = exerciseItem.id 
          this.readFileExercise(this.exerciseId); // Store the exercise ID
          console.log(exerciseItem.id)
        }
      }
    );
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

    this.updateExerciseServiceService.updateClassService(this.exercise).subscribe(
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
    this.deleteExerciseServiceService.deleteExerciseService(this.listExerciseDomain[i].id).subscribe(
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

