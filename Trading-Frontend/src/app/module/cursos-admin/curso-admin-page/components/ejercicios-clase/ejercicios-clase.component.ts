import { Component } from '@angular/core';
import { BOOK1, GRAFICEXERCISE } from 'src/app/shared/constants';

@Component({
  selector: 'app-ejercicios-clase',
  templateUrl: './ejercicios-clase.component.html',
  styleUrls: ['./ejercicios-clase.component.scss']
})
export class EjerciciosClaseComponent {
  graficExercise = GRAFICEXERCISE;

}
