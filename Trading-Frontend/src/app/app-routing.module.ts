import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginModule } from './module/login/login.module';


const routes: Routes = [
  {path:'', redirectTo: '/home-page', pathMatch:'full'}, 
  {path:'home-page', loadChildren: () => import('./module/home/home.module').then (m => m.HomeModule)},
  {path:'login-page', loadChildren: () => import('./module/login/login.module').then (m => m.LoginModule )}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
