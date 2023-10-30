import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadUserEmailService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/user";

  readUserEmail(email: string) :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(`${this.API}/user_read?email=${email}`);
  }
}
