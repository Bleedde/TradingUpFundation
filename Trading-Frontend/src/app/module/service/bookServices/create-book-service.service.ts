import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { BookDomain } from '../../cursos-admin/curso-admin-page/components/libros/domains/BookDomain';


@Injectable({
  providedIn: 'root'
})
export class CreateBookServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/book";

  createBookService(bookDomain: BookDomain): Observable<GenericResponse> {
    return this.http
    .post<GenericResponse>(this.API + "/book_create", bookDomain )
  }
}
