import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomePageComponent } from './home-page/home-page.component';
import { NavbarComponent } from './home-page/components/navbar/navbar.component';
import { CarrouselComponent } from './home-page/components/carrousel/carrousel.component';
import { QuienesSomosComponent } from './home-page/components/quienes-somos/quienes-somos.component';
import { VisionMisionComponent } from './home-page/components/vision-mision/vision-mision.component';
import { EquipoComponent } from './home-page/components/equipo/equipo.component';
import { ComunidadComponent } from './home-page/components/comunidad/comunidad.component';
import { ContactoComponent } from './home-page/components/contacto/contacto.component';
import { FooterComponent } from './home-page/components/footer/footer.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { InfoCursosComponent } from './home-page/components/info-cursos/info-cursos.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    HomePageComponent,
    NavbarComponent,
    CarrouselComponent,
    QuienesSomosComponent,
    VisionMisionComponent,
    EquipoComponent,
    ComunidadComponent,
    ContactoComponent,
    FooterComponent,
    InfoCursosComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    HttpClientModule,

  ]
})
export class HomeModule { }
