import { Component } from '@angular/core';

@Component({
  selector: 'app-slide-var',
  templateUrl: './slide-var.component.html',
  styleUrls: ['./slide-var.component.scss']
})
export class SlideVarComponent {

  dropdown1: boolean = true;
  dropdown2: boolean = true;
  dropdown3: boolean = true;
  dropdown4: boolean = true;
  
  dropDown1(){
    this.dropdown1 = !this.dropdown1; 
  }

  dropDown2(){
    this.dropdown2 = !this.dropdown2; 
  }

  dropDown3(){
    this.dropdown3 = !this.dropdown3; 
  }

  dropDown4(){
    this.dropdown4 = !this.dropdown4; 
  }
}
