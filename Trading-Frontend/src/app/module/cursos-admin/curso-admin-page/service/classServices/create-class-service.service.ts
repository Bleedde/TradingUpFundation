import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class CreateClassServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class";

  createUserService(userDomain: UserDomain): Observable<GenericResponse> {

    console.log("Prueba Datos: " + userDomain.name)
    console.log("Prueba Datos: " + userDomain.email)
    console.log("Prueba Datos: " + userDomain.password)

    return this.http
    .post<GenericResponse>(this.API + "/class _create", userDomain )
  }
}
