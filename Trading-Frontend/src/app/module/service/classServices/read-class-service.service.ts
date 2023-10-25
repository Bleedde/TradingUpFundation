import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class ReadClassServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class";

  readClassService() :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/class_read")
  }
}
