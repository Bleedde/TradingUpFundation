import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RoutCursosGuardianService {

  cursosTokenSave(message:string): void{
    localStorage.setItem('guardianCursos', message);
  }

  cursosAccessTokenGet(){
    return localStorage.getItem('guardianCursos')
  }

  cursosAccessTokenRemove(): void {
    localStorage.removeItem('guardianCursos')
  }
}
