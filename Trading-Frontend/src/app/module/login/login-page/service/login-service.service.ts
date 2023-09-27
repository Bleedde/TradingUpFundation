import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GeneralResponse } from 'src/app/shared/response/GeneralResponse';



@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http: HttpClient) { }

  loginService(params:{email : string, password : string}): Observable<GeneralResponse>{
    return this.http.post<GeneralResponse>(
      "http://localhost:8080/login" + "/service",  params
    )
  }
}
