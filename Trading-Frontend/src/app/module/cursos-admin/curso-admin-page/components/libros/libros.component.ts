import { Component } from '@angular/core';
import { BOOK1, BOOK2 } from 'src/app/shared/constants';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss']
})
export class LibrosComponent {
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
  }
  }

  
