import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class ReadBooksServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/book";

  readBooksService() :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/books_read")
  }
}
