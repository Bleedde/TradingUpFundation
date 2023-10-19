import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BOOK1, BOOK2 } from 'src/app/shared/constants';
import { CreateBookServiceService } from '../../service/bookServices/create-book-service.service';
import { DeleteBookServiceService } from '../../service/bookServices/delete-book-service.service';
import { ReadBooksServiceService } from '../../service/bookServices/read-books-service.service';
import { UpdateBookServiceService } from '../../service/bookServices/update-book-service.service';
import { GenericResponse } from '../../service/response/GenericResponse';
import { BookDomain } from './domains/BookDomain';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss']
})
export class LibrosComponent implements OnInit{
  
  bookForm!: FormGroup;
  bookDomain!: BookDomain;
  listBookDomain: BookDomain [] = [];
  editBookDomain!: boolean;
  id!: number;

  niveles: { value: string; label: string }[] = [
    { value: '1', label: 'Nivel 1' },
    { value: '2', label: 'Nivel 2' },
    { value: '3', label: 'Nivel 3' },
    { value: '4', label: 'Nivel 4' },
  ];
  nivelSeleccionado: string = '1';

  private valoresInicialesFormulario: any;

  book!: BookDomain;

  constructor(public formulary: FormBuilder, private createBookServiceService: CreateBookServiceService, private readBooksServiceService: ReadBooksServiceService, private UpdateBookServiceService: UpdateBookServiceService, private DeleteBookServiceService: DeleteBookServiceService){
    this.bookForm = formulary.group({
      name: ['',[Validators.required]],
      description: ['',[Validators.required]],
      image: ['',[Validators.required]],
      file: ['',[Validators.required]],
      bookLevel: [0,[Validators.required]]
    })
  }

  ngOnInit(): void {

    this.bookForm = this.formulary.group({
      name: ['',[Validators.required]],
      description: ['',[Validators.required]],
      image: ['',[Validators.required]],
      file: ['',[Validators.required]],
      bookLevel: [0,[Validators.required]]
    });

    // Guarda los valores iniciales del formulario
    this.valoresInicialesFormulario = this.bookForm.value;

    this.readBooksService();
  }

  createBook() {
    if (!this.bookForm.valid) {
      return this.bookForm.markAllAsTouched()
    }
    else {
      this.bookDomain = {
        id: 0,
        name: this.bookForm.controls['name'].value,
        description: this.bookForm.controls['description'].value,
        file: this.bookForm.controls['file'].value,
        image: this.bookForm.controls['image'].value,
        bookLevel: this.bookForm.controls['bookLevel'].value != 0
          ? this.bookForm.controls['bookLevel'].value
          : 1,
      }

      console.log("prueba de class" + this.bookDomain.bookLevel)

      this.createBookServiceService.createBookService(this.bookDomain).subscribe(
        (res: GenericResponse) => {
          console.log("Esta es la Respuesta: " + res.message)
          if (res.httpResponse == 200) {
            window.location.reload()
          }
        }
      )
    }
  }

  readBooksService() {
    this.readBooksServiceService.readBooksService().subscribe(
      (res: GenericResponse) => {
        for (let bookItem of res.objectResponse) {
          this.listBookDomain.push(bookItem);
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
    this.nivelSeleccionado = this.book.bookLevel.toString();

    /*Actualiza el FormGroup con los valores iniciales*/
    this.bookForm.patchValue({
      bookLevel: this.nivelSeleccionado
    });
  }

  updateClass() {
    this.book = {
      id: this.listBookDomain[this.id].id,
      name: this.bookForm.controls['name'].value != ''
        ? this.bookForm.controls['name'].value
        : this.listBookDomain[this.id].name,
      description: this.bookForm.controls['description'].value != ''
        ? this.bookForm.controls['description'].value
        : this.listBookDomain[this.id].description,
      file: this.bookForm.controls['file'].value != ''
        ? this.bookForm.controls['file'].value
        : this.listBookDomain[this.id].file,
      image: this.bookForm.controls['image'].value != ''
        ? this.bookForm.controls['image'].value
        : this.listBookDomain[this.id].image,
      bookLevel: this.bookForm.controls['bookLevel'].value != null
        ? this.bookForm.controls['bookLevel'].value
        : this.listBookDomain[this.id].bookLevel,
    }

    this.UpdateBookServiceService.updateBookService(this.book).subscribe(
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
    this.DeleteBookServiceService.deleteBookService(this.listBookDomain[i].id).subscribe(
      (res: GenericResponse) => {
        console.log("Esta es la Respuesta: " + res.message)

        if (res.httpResponse == 200) {
          window.location.reload()
        }
      }
    )
  }


  cancelarEdicion() {
    this.editBookDomain = false;

    // Restablecer el formulario a los valores iniciales guardados
    this.bookForm.setValue(this.valoresInicialesFormulario);
  }
  
  
  
  
  
  /*
  book1 = BOOK1;
  book2 = BOOK2;
  registroPdf: any [][] = [[],[]];
  constructor(){
    this.registroPdf = [[
      {imagen: this.book1, titulo: "Tradin Sin Ego", descripcion: "Aprende a controlar tus cesgos egolatras", nivel: "nivel 1", link: "/aaa"},
    {imagen: this.book2, titulo: "Chartismo", descripcion: "Aprende a controlar tus cesgos egolatras", nivel: "nivel 1", link: "/aaa"},
    {imagen: this.book1, titulo: "Velas Japonesas", descripcion: "Aprende a controlar tus cesgos egolatras", nivel: "nivel 1", link: "/aaa"}],

    [{imagen: this.book2, titulo: "Chartismo", descripcion: "Aprende a controlar tus cesgos egolatras", nivel: "nivel 1", link: "/aaa"},
    {imagen: this.book1, titulo: "Tradin Sin Ego", descripcion: "Aprende a controlar tus cesgos egolatras", nivel: "nivel 1", link: "/aaa"},
    {imagen: this.book2, titulo: "Chartismo", descripcion: "Aprende a controlar tus cesgos egolatras", nivel: "nivel 1", link: "/aaa"}]
      
      ];
  }*/
}

  
