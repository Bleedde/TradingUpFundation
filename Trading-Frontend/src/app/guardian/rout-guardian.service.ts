import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RoutGuardianService {

  generalTokenSave(message:string): void{
    localStorage.setItem('guardian', message);
  }

  generalAccessTokenGet(){
    return localStorage.getItem('guardian')
  }

  generalAccessTokenRemove(): void {
    localStorage.removeItem('guardian')
  }
}
