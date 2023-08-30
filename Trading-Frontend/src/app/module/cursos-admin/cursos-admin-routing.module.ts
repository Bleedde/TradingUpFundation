import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursoAdminPageComponent } from './curso-admin-page/curso-admin-page.component';

const routes: Routes = [
  {path:'', component: CursoAdminPageComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CursosAdminRoutingModule { }
