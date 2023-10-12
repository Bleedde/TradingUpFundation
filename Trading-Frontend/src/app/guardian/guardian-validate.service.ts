import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import { RoutGuardianService } from './rout-guardian.service';

@Injectable({
  providedIn: 'root'
})
export class GuardianValidateService implements CanActivate{

  constructor(private routGuardianService: RoutGuardianService, private router: Router) { }

  canActivate(): boolean{
    const accesToken = this.routGuardianService.generalAccessTokenGet();
    if(!accesToken){
      this.router.navigate(['']);
      return false;
    }
    return true;
  }
}
