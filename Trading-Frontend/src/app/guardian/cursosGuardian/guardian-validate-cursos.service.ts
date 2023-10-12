import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { RoutCursosGuardianService } from './rout-cursos-guardian.service';

@Injectable({
  providedIn: 'root'
})
export class GuardianValidateCursosService {

  constructor(private routCursosGuardianService: RoutCursosGuardianService, private router: Router) { }

  canActivate(): boolean{
    const accesToken = this.routCursosGuardianService.cursosAccessTokenGet();
    if(!accesToken){
      this.router.navigate(['']);
      return false;
    }
    return true;
  }
}
