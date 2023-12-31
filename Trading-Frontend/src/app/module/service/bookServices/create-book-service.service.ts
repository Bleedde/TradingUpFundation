import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { BookDomain } from '../../../shared/domains/BookDomain';


@Injectable({
  providedIn: 'root'
})
export class CreateBookServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/book";

  createBookService(formData: FormData): Observable<GenericResponse> {
    return this.http
    .post<GenericResponse>(this.API + "/book_create", formData )
  }
}
