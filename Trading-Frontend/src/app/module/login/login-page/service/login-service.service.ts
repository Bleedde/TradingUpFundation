import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { RoutGuardianService } from 'src/app/guardian/rout-guardian.service';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';




@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient) { }

  loginService(params:{email : string, password : string}): Observable<GenericResponse>{
    console.log("valor del params: " + params.email);
    return this.http.post<GenericResponse>(
      "http://localhost:8080/user" + "/login",  params
    )
  }
}