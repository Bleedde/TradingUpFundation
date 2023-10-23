import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { ClassDomain } from '../../cursos-admin/curso-admin-page/components/clases-grabadas/domains/ClassDomain';


@Injectable({
  providedIn: 'root'
})
export class CreateClassServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class";

  createClassService(classDomain: ClassDomain): Observable<GenericResponse> {
    return this.http
    .post<GenericResponse>(this.API + "/class_create", classDomain )
  }
}
