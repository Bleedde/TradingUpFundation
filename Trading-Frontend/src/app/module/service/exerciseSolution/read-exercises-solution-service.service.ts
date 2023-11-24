import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadExercisesSolutionServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/exercise_solution";

  readExerciseSolutionsService(exerciseId: number): Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/exercise_solutions_read" + exerciseId)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          let errorMessage = 'Error desconocido';
          if (error.error instanceof ErrorEvent) {
            // Error del lado del cliente
            errorMessage = `Error: ${error.error.message}`;
          } else {
            // El servidor devolvió un código de estado diferente de 200
            errorMessage = `Error: ${error.status}, ${error.error.message}`;
          }

          // Puedes mostrar la alerta aquí
          alert('pepe');

          // Luego, propagar el error para que el consumidor del servicio también pueda manejarlo si es necesario
          return throwError(errorMessage);
        })
      );
  }
}
