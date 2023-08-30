import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient) { }

  loginService(params:{correo : string, contrasenia : string}): Observable<GenericResponse>{
    return this.http.post<any>(
      "http://localhost:8080/usuario" + "/service",  params
    )
  }
}
