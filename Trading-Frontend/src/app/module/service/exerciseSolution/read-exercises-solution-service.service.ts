import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { Alerts } from 'src/app/shared/alerts/alerts';

@Injectable({
  providedIn: 'root'
})
export class ReadExercisesSolutionServiceService {
  
  private alerts: Alerts = new Alerts();
  constructor(private http: HttpClient) { }
  
  API: string = "http://localhost:8080/exercise_solution";

  readExerciseSolutionsService(exerciseId: number): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/exercise_solutions_read" + exerciseId)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          // Puedes mostrar la alerta aquí
          this.alerts.showModalExerciseA();

          // Luego, propagar el error para que el consumidor del servicio también pueda manejarlo si es necesario
          return throwError("error");
        })
      );
  }
}
