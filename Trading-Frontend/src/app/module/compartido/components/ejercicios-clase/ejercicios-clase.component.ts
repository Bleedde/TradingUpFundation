import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { CreateExerciseSolutionServiceService } from 'src/app/module/service/exerciseSolution/create-exercise-solution-service.service';
import { ReadExerciseSolutionServiceService } from 'src/app/module/service/exerciseSolution/read-exercise-solution-service.service';
import { ReadExercisesSolutionServiceService } from 'src/app/module/service/exerciseSolution/read-exercises-solution-service.service';
import { CreateExerciseServiceService } from 'src/app/module/service/exercises/create-exercise-service.service';
import { DeleteExerciseServiceService } from 'src/app/module/service/exercises/delete-exercise-service.service';
import { ReadExercisesServiceService } from 'src/app/module/service/exercises/read-exercises-service.service';
import { ReadFileExerciseService } from 'src/app/module/service/exercises/read-file-exercise.service';
import { UpdateExerciseServiceService } from 'src/app/module/service/exercises/update-exercise-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';
import { BOOK1, GRAFICEXERCISE } from 'src/app/shared/constants';
import { ExerciseDomain } from 'src/app/shared/domains/ExerciseDomain';
import { ExerciseSolution } from 'src/app/shared/domains/ExerciseSolution';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-ejercicios-clase',
  templateUrl: './ejercicios-clase.component.html',
  styleUrls: ['./ejercicios-clase.component.scss']
})
export class EjerciciosClaseComponent implements OnInit{
  graficExercise = GRAFICEXERCISE;
  userRole!: string;
  userName!: string;

  fileNameVariable!: string;
  solutionFileNameVariable!: string
  fileType!: string;
  solutionFileType!: string;
  fileToUpload: File | null = null;
  solutionFileToUpload: File | null = null;


  exerciseForm!: FormGroup;
  exerciseSolutionForm!: FormGroup;
  exerciseDomain!: ExerciseDomain;
  listExerciseDomain: ExerciseDomain[] = [];
  listExerciseSolution: ExerciseSolution[] = [];
  exerciseIds: ExerciseDomain[] = [];
  editExerciseDomain!: boolean;
  id!: number;
  idExercise!: number;

  buttonValue!: number
  userToEdit: { userLevel: number, email: string } = { userLevel: 0, email: ''};
  availableLevels = [1, 2, 3, 4]; 
  selectedLevel: number | undefined;
  showBoxResponse: boolean[] = [];
  showSolutions: boolean[] = [];

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

  constructor(public formulary: FormBuilder, private createExerciseServiceService: CreateExerciseServiceService, private readExercisesServiceService: ReadExercisesServiceService, private updateExerciseServiceService: UpdateExerciseServiceService, private deleteExerciseServiceService: DeleteExerciseServiceService, private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService, private createExerciseSolutionServiceService: CreateExerciseSolutionServiceService, private readExercisesSolutionServiceService: ReadExercisesSolutionServiceService, private readExerciseSolutionServiceService: ReadExerciseSolutionServiceService) {

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

    this.exerciseSolutionForm = formulary.group(
      {
        comment: ['', [Validators.required]],
        userEmail: ['', [Validators.required]],
        exerciseId: ['', [Validators.required]],
        file: ['', [Validators.required]]
      }
    )
    
  }
  initializeComponentData() {
    this.showSolutions = new Array(this.listExerciseDomain.length).fill(false);
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
      formData.append('id', '1');
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

  handleInputEventSolution(event: any) {
    const fileInputSolution = event.target.files[0]; // Obtén el archivo seleccionado por el usuario
    if (fileInputSolution) {
      this.solutionFileNameVariable = fileInputSolution.name;
      this.solutionFileType = fileInputSolution.type; // Guarda el nombre real del archivo en la variable
      this.solutionFileToUpload = fileInputSolution;
      const formData = new FormData();
      formData.append('fileSolution', fileInputSolution); // Agrega el archivo al objeto FormData
      // Puedes hacer más acciones con el archivo aquí si es necesario
      console.log(`Archivo seleccionado: ${this.solutionFileNameVariable}`);
      console.log(`Tipo de archivo: ${this.solutionFileType}`);
      console.log(`Archivo a subir: ${this.solutionFileToUpload}`);
    } else {
      console.log('Ningún archivo seleccionado.');
    }
  }

  createExerciseSolution(i:number){
    this.id = i;
    this.exercise = this.listExerciseDomain[this.id];
    console.log('create exercise se esta llamando')
      const formData = new FormData();
      // Agrega los demás campos de formulario
      formData.append('id', '1');
      formData.append('comment', this.exerciseSolutionForm.get('comment')?.value || '');
      formData.append('userEmail', this.userToEdit.email);
      formData.append('exerciseId', this.exercise.id.toString());
      const fileInputSolution = this.exerciseSolutionForm.get('file');
      if (fileInputSolution instanceof FormControl) {
        const file: File | null = fileInputSolution.value;
        if (file) {
          const blob = new Blob([this.solutionFileToUpload!], { type: this.solutionFileType });
          formData.append('file', this.solutionFileToUpload!, this.solutionFileNameVariable); // Usa el nombre real del archivo
        }
      }
      // Imprime los datos antes de la llamada al servicio
      console.log('Datos a enviar:');
      formData.forEach((value, key) => {
        console.log(`${key}: ${value}`);
      });
      // Llama al servicio para enviar los datos al backend
      this.createExerciseSolutionServiceService.createExerciseSolutionService(formData).subscribe(
        (res: GenericResponse) => {
          console.log('Respuesta del servidor: ' + res.message);
          if (res.httpResponse === 200) {
            window.location.reload();
          }
        },
        (error) => {
          console.error('Error al enviar el formulario:', error);
        }
      );
  }

  readUserLevel() {
    const userId = this.datosUserServiceService.getUserId();
    this.readUserIdService.readUserId(userId!).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200) {
          this.userToEdit = res.objectResponse;
          console.log('nivel del usuario ' + this.userToEdit.userLevel);
          console.log('email del usuario ' + this.userToEdit.email);
          this.userName = res.objectResponse.name
          console.log('nombre: ', this.userName)
        }
      }
    );
  }

  readFileExercise(id: number) {
    return `http://localhost:8080/exercise/exercise_file${id}`; 
  }

  readFileSolution(id:number){
    return `http://localhost:8080/exercise_solution/exercise_solution_file${id}`;
  }

  readExerciseSolutionsService(i: number) {
    this.showSolutions[i] = !this.showSolutions[i];
    this.id = i;
    this.exercise = this.listExerciseDomain[this.id];
    console.log("este es" + this.exercise.id);
    i = this.exercise.id;
    console.log("este es i: " + i);
    this.listExerciseSolution = [];
  
    this.readExercisesSolutionServiceService.readExerciseSolutionsService(i).subscribe(
      (res: GenericResponse) => {
        if(res.httpResponse === 200 && res.objectResponse.length > 0){
          for(let exerciseSolutionItem of res.objectResponse){
            this.listExerciseSolution.push(exerciseSolutionItem);
            this.readFileSolution(exerciseSolutionItem.id);
            console.log("holaa")
          }
        }
        else{
          alert("no hay ejercicios resueltos")
        }
      }
    )
  }


  readExerciseSolutionService(i: number){
    this.showBoxResponse[i] = !this.showBoxResponse[i];
    this.id = i;
    this.exercise = this.listExerciseDomain[this.id];
    console.log("este es" + this.exercise.id);
    i = this.exercise.id;
    console.log("este es i: " + i);
    this.listExerciseSolution = [];
    const params = {
      userEmail : this.userToEdit.email,
      exerciseId : i
    }

    this.readExerciseSolutionServiceService.readExerciseSolutionService(params).subscribe(
      (res: GenericResponse) => {
        if(res.httpResponse === 200 && res.objectResponse.length > 0){
          for(let exerciseSolutionItem of res.objectResponse){
            this.listExerciseSolution.push(exerciseSolutionItem);
            this.readFileSolution(exerciseSolutionItem.id);
            console.log("holaa")
          }
        }
      }
    )
  }

  readExercisesService(level: number) {
    this.listExerciseDomain = [];
    this.exerciseIds = [];  // Create an array to store exercise IDs
  
    this.readExercisesServiceService.readExercisesService(level).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200 && res.objectResponse.length > 0){
          for (let exerciseItem of res.objectResponse) {
            this.listExerciseDomain.push(exerciseItem);
            this.exerciseIds.push(exerciseItem.id);
            this.readFileExercise(exerciseItem.id); // Store the exercise ID
            console.log("id de los ejercicios: " + exerciseItem.id)
          }
        }
        else{
          alert("no hay ejercicios")
        }
      },
      (error) => {
        console.error('Error al enviar el formulario:', error);
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
      level: this.nivelSeleccionado
    });
  }

  updateExercise() {
    if (!this.exerciseForm.valid) {
      return this.exerciseForm.markAllAsTouched();
    } else {
      const formData = new FormData();
      // Agrega los demás campos de formulario
      formData.append('id', this.listExerciseDomain[this.id].id.toString()); // Suponiendo que tengas una variable que almacena el ID del ejercicio a actualizar
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
          formData.append('file', this.fileToUpload!, this.fileNameVariable);
        }
      }
      
      // Imprime los datos antes de la llamada al servicio
      console.log('Datos a enviar:');
      formData.forEach((value, key) => {
        console.log(`${key}: ${value}`);
      });
      
      // Llama al servicio para enviar los datos al backend
      this.updateExerciseServiceService.updateExerciseService(formData).subscribe(
        (res: GenericResponse) => {
          console.log('Respuesta del servidor: ' + res.message);
          if (res.httpResponse === 200) {
            window.location.reload();
          }
        },
        (error) => {
          console.error('Error al enviar el formulario:', error);
        }
      );
    }
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

  validatePermision() {
    return this.compartidoServiceService.getData();
  }

}

