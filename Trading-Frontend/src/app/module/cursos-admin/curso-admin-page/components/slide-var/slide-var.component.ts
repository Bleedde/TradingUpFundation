import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-slide-var',
  templateUrl: './slide-var.component.html',
  styleUrls: ['./slide-var.component.scss']
})
export class SlideVarComponent implements OnChanges {

  ngOnChanges(changes: SimpleChanges): void {
    console.log("cambio efectuado " + changes['datosUser1'])
    this.datosUser = this.datosUser1;
    this.datosContent = this.datosContent1;
  }

  @Input() datosUser1!: boolean;
  @Input() datosContent1!: boolean;
  @Output() activateSectionUsers = new EventEmitter<boolean>();
  @Output() activateSectionContents = new EventEmitter<boolean>();

  datosUser = false;
  datosContent = false;

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

  activateSectionUser(){
    this.activateSectionUsers.emit(this.datosUser = !this.datosUser);
  }

  activateSectionContent(){
    this.activateSectionContents.emit(this.datosContent = !this.datosContent);
  }



  
}
