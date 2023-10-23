import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DatosUserServiceService{

  private key = "user-login";

  setUser(userId: string): void{
    localStorage.setItem(this.key, userId.toString());
  }

  getUser(){
    const VAlUE = localStorage.getItem(this.key);
    return VAlUE ? parseFloat(VAlUE) : 0;
  }
}
