import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { ExerciseDomain } from '../../../shared/domains/ExerciseDomain';

@Injectable({
  providedIn: 'root'
})
export class CreateExerciseServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/exercise";

  createExerciseService(formData: FormData): Observable<GenericResponse> {
    return this.http
    .post<GenericResponse>(this.API + "/exercise_create", formData )
  }
}
