import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardianValidateCursosService } from './guardian/cursosGuardian/guardian-validate-cursos.service';
import { GuardianValidateService } from './guardian/guardian-validate.service';
import { LoginModule } from './module/login/login.module';


const routes: Routes = [
  {path:'', redirectTo: '/home-page', pathMatch:'full'}, 
  {path:'home-page', loadChildren: () => import('./module/home/home.module').then (m => m.HomeModule)},
  {path:'login-page', loadChildren: () => import('./module/login/login.module').then (m => m.LoginModule )},
  {path:'cursos-page', canActivate: [GuardianValidateCursosService],loadChildren: () => import('./module/cursos/cursos.module').then (m => m.CursosModule )},
  {path:'cursosAdmin-page', canActivate: [GuardianValidateService], loadChildren: () => import('./module/cursos-admin/cursos-admin.module').then (m => m.CursosAdminModule )}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
