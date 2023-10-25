import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { UserDomain } from '../../../shared/domains/UserDomain';



@Injectable({
  providedIn: 'root'
})

export class CreateUserServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/user";

  createUserService(userDomain: UserDomain): Observable<GenericResponse> {

    console.log("Prueba Datos: " + userDomain.userLevel)

    return this.http
    .post<GenericResponse>(this.API + "/user_create", userDomain )
  }

}
