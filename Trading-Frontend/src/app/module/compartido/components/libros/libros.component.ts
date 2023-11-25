import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { CreateBookServiceService } from 'src/app/module/service/bookServices/create-book-service.service';
import { DeleteBookServiceService } from 'src/app/module/service/bookServices/delete-book-service.service';
import { ReadBooksServiceService } from 'src/app/module/service/bookServices/read-books-service.service';
import { UpdateBookServiceService } from 'src/app/module/service/bookServices/update-book-service.service';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';
import { Alerts } from 'src/app/shared/alerts/alerts';
import { BookDomain } from 'src/app/shared/domains/BookDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss']
})
export class LibrosComponent {
  private alerts: Alerts = new Alerts();
  fileNameVariable!: string;
  imageFileNameVariable!: string
  fileType!: string;
  imageFileType!: string;
  fileToUpload: File | null = null;
  imageFileToUpload: File | null = null;
  


  bookForm!: FormGroup;
  bookDomain!: BookDomain;
  listBookDomain: BookDomain [] = [];
  bookIds: BookDomain [] = [];
  editBookDomain!: boolean;
  id!: number;
  bookId!: number;

  buttonValue!: number
  userToEdit: { userLevel: number } = { userLevel: 0 };
  availableLevels = [1, 2, 3, 4]; 
  selectedLevel: number | undefined;
  showBoxResponse: boolean = false;

  buttonClicked(level: number) {
    this.selectedLevel = level; // Almacena el valor de level en la variable selectedLevel
    this.readBooksService(this.selectedLevel);
  }

  libros!: boolean;
  mensaje!: boolean;

  niveles: { value: string; label: string }[] = [
    { value: '1', label: 'Nivel 1' },
    { value: '2', label: 'Nivel 2' },
    { value: '3', label: 'Nivel 3' },
    { value: '4', label: 'Nivel 4' },
  ];
  nivelSeleccionado: string = '1';

  private valoresInicialesFormulario: any;

  book!: BookDomain;

  constructor(public formulary: FormBuilder, private createBookServiceService: CreateBookServiceService, private readBooksServiceService: ReadBooksServiceService, private updateBookServiceService: UpdateBookServiceService, private deleteBookServiceService: DeleteBookServiceService ,private compartidoServiceService: CompartidoServiceService, private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService){

    this.libros = this.compartidoServiceService.getData();
    this.mensaje = this.compartidoServiceService.getData();

    this.bookForm = formulary.group({
      name: ['',[Validators.required]],
      description: ['',[Validators.required]],
      image: ['',[Validators.required]],
      file: ['',[Validators.required]],
      level: [0,[Validators.required]]
    })
  }

  ngOnInit(): void {

    this.bookForm = this.formulary.group({
      name: ['',[Validators.required]],
      description: ['',[Validators.required]],
      image: ['',[Validators.required]],
      file: ['',[Validators.required]],
      level: [this.nivelSeleccionado]
    });

    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.bookForm.value;
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

  handleInputEventImage(event: any) {
    const fileInputImage = event.target.files[0]; // Obtén el archivo seleccionado por el usuario
    if (fileInputImage) {
      this.imageFileNameVariable = fileInputImage.name;
      this.imageFileType = fileInputImage.type; // Guarda el nombre real del archivo en la variable
      this.imageFileToUpload = fileInputImage;
      const formData = new FormData();
      formData.append('image', fileInputImage); // Agrega el archivo al objeto FormData
      // Puedes hacer más acciones con el archivo aquí si es necesario
      console.log(`Archivo seleccionado: ${this.imageFileNameVariable}`);
      console.log(`Tipo de archivo: ${this.imageFileType}`);
      console.log(`Archivo a subir: ${this.imageFileToUpload}`);
    } else {
      console.log('Ningún archivo seleccionado.');
    }
  }

  createBook() {
    if (!this.bookForm.valid) {
      return this.bookForm.markAllAsTouched()
    }
    else {
      const formData = new FormData();

      formData.append('id', "0");
      formData.append('name', this.bookForm.get('name')?.value || '')
      formData.append('description', this.bookForm.get('description')?.value || '')
      const selectedLevel = this.bookForm.get('level')?.value || '1';
      formData.append('level', selectedLevel);
      const fileInputImage = this.bookForm.get('image');
      if (fileInputImage instanceof FormControl) {
        const image: File | null = fileInputImage.value;
        if (image) {
          const blob = new Blob([this.imageFileToUpload!], { type: this.imageFileType });
          formData.append('image', this.imageFileToUpload!, this.imageFileNameVariable); // Usa el nombre real del archivo
        }
      }
      const fileInput = this.bookForm.get('file');
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

      this.createBookServiceService.createBookService(formData).subscribe(
        (res: GenericResponse) => {
          console.log('Respuesta del servidor: ' + res.message);
          if (res.httpResponse === 200) {
            this.alerts.showModalCreated()
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

  readFileBook(id: number) {
    return `http://localhost:8080/book/book_file${id}`; 
  }

  readImageBook(id: number){
    return `http://localhost:8080/book/book_image${id}`;
  }

  readBooksService(level: number) {
    this.listBookDomain = [];
    this.bookIds = [];
    
    this.readBooksServiceService.readBooksService(level).subscribe(
      (res: GenericResponse) => {
        if (res.httpResponse === 200 && res.objectResponse.length > 0){
          for (let bookItem of res.objectResponse) {
            this.listBookDomain.push(bookItem);
            this.bookIds.push(bookItem.id);
            this.readFileBook(bookItem.id);
            this.readImageBook(bookItem.id) // Store the exercise ID
            console.log(bookItem.id)
          }
        }else{
          this.alerts.showModalBooks();
        }
        
      }
    )
  }

  editBook(i: number) {
    this.editBookDomain = true;
    this.id = i;
    this.book = this.listBookDomain[this.id];

    console.log(this.book);
    // Configura el valor inicial de nivelSeleccionado y estadoSeleccionado
    this.nivelSeleccionado = this.book.level.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.bookForm.patchValue({
      level: this.nivelSeleccionado
    });
  }

  updateBook() {
    if (!this.bookForm.valid) {
      return this.bookForm.markAllAsTouched();
    } else {
      const formData = new FormData();
      // Agrega los demás campos de formulario
      formData.append('id', this.listBookDomain[this.id].id.toString()); // Suponiendo que tengas una variable que almacena el ID del ejercicio a actualizar
      formData.append('name', this.bookForm.get('name')?.value || '');
      formData.append('description', this.bookForm.get('description')?.value || '');
      const fileInput = this.bookForm.get('file'); 
      if (fileInput instanceof FormControl) {
        const file: File | null = fileInput.value;
        if (file) {
          const blob = new Blob([this.fileToUpload!], { type: this.fileType });
          formData.append('file', this.fileToUpload!, this.fileNameVariable);
        }
      }
      const fileInputImage = this.bookForm.get('image');
      if (fileInputImage instanceof FormControl) {
        const image: File | null = fileInputImage.value;
        if (image) {
          const blob = new Blob([this.imageFileToUpload!], { type: this.imageFileType });
          formData.append('image', this.imageFileToUpload!, this.imageFileNameVariable); // Usa el nombre real del archivo
        }
      }
      const selectedLevel = this.bookForm.get('level')?.value || '1';
      formData.append('level', selectedLevel);
      
      
      // Imprime los datos antes de la llamada al servicio
      console.log('Datos a enviar:');
      formData.forEach((value, key) => {
        console.log(`${key}: ${value}`);
      });
      
      // Llama al servicio para enviar los datos al backend
      this.updateBookServiceService.updateBookService(formData).subscribe(
        (res: GenericResponse) => {
          console.log('Respuesta del servidor: ' + res.message);
          if (res.httpResponse === 200) {
            this.alerts.showModalUpdated();
          }
        },
        (error) => {
          console.error('Error al enviar el formulario:', error);
        }
      );
    }
  }

  deleteBook(i: number) {
    this.deleteBookServiceService.deleteBookService(this.listBookDomain[i].id).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          this.alerts.showModalDelete();
        }
      }
    )
  }

  cancelarEdicion() {
    this.editBookDomain = false;

    // Restablecer el formulario a los valores iniciales guardados
    this.bookForm.setValue(this.valoresInicialesFormulario);
  }
  
}
