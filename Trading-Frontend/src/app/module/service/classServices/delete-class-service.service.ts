import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class DeleteClassServiceService {

  constructor(private http: HttpClient) { }

    API: string = "http://localhost:8080/class";

  deleteClassService(id: number) :Observable<GenericResponse> {
    return this.http.delete<GenericResponse>(this.API + "/class_delete" + id)
  }
}
