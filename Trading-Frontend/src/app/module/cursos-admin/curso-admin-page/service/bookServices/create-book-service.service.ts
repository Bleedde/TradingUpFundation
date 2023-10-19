import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookDomain } from '../../components/libros/domains/BookDomain';
import { GenericResponse } from '../response/GenericResponse';

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
