import { Component } from '@angular/core';
import { GRAFICEXERCISE, WALLPAPER, WALLPAPER1 } from 'src/app/shared/constants';

@Component({
  selector: 'app-start-a',
  templateUrl: './start-a.component.html',
  styleUrls: ['./start-a.component.scss']
})
export class StartAComponent {
  wallpaper = WALLPAPER;
  wallpaper1 = WALLPAPER1;

}
