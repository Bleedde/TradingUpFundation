import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { ExerciseDomain } from '../../cursos-admin/curso-admin-page/components/ejercicios-clase/domains/ExerciseDomain';

@Injectable({
  providedIn: 'root'
})
export class UpdateExerciseServiceService {

  constructor(private http: HttpClient) {}

  API: string = "http://localhost:8080/exercise";

  updateClassService(exerciseDomain : ExerciseDomain) :Observable<GenericResponse> {
    return this.http.put<GenericResponse>(this.API + "/exercise_update", exerciseDomain)
  }
}
