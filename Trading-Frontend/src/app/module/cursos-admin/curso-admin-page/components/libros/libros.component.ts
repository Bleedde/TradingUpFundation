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
}
