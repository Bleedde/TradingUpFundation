import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { ClassDomain } from '../../../shared/domains/ClassDomain';


@Injectable({
  providedIn: 'root'
})
export class UpdateClassServiceService {

  constructor(private http: HttpClient) {}

  API: string = "http://localhost:8080/class";

  updateClassService(classDomain : ClassDomain) :Observable<GenericResponse> {
    return this.http.put<GenericResponse>(this.API + "/class_update", classDomain)
  }
}
