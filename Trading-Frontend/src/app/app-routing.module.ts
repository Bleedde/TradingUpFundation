import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeModule } from './module/home/home.module';


const routes: Routes = [
  {path:'', redirectTo: '/home-page', pathMatch:'full'}, 
  {path:'home-page', loadChildren: () => import('./module/home/home.module').then (m => m.HomeModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
