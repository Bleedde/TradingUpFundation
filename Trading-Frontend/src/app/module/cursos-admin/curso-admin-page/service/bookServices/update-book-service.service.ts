import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookDomain } from '../../components/libros/domains/BookDomain';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class UpdateBookServiceService {

  constructor(private http: HttpClient) {}

  API: string = "http://localhost:8080/book";

  updateBookService(bookDomain: BookDomain) :Observable<GenericResponse> {
    return this.http.put<GenericResponse>(this.API + "/book_update", bookDomain)
  }
}
