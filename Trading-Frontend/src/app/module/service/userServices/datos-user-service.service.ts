import { Injectable } from '@angular/core';
import { UserDomain } from 'src/app/shared/domains/UserDomain';

@Injectable({
  providedIn: 'root'
})
export class DatosUserServiceService{

  private key = "user-login";

  // Método para almacenar el ID del usuario en el localStorage
  setUserId(userId: number): void {
  localStorage.setItem(this.key, userId.toString());
  }

  // Método para recuperar el ID del usuario del localStorage
  getUserId(): number | null {
    const userId = localStorage.getItem(this.key);
    return userId ? parseInt(userId, 10) : null;
  }

  setUserEmail(email: string): void {
    localStorage.setItem(this.key, email);
  }

  // Método para recuperar el email del usuario del localStorage
  getUserEmail(): string | null {
    const userEmail = localStorage.getItem(this.key);
    return userEmail || null;
  }

  userIdAccessTokenRemove(): void {
    localStorage.removeItem('user-login')
  }
}
