import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';

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
    this.datosBooks = this.datosBooks1;
    this.datosExercise = this.datosExercises1;
    this.datosClass = this.datosClass1;
    this.datosPrerecorded = this.datosPrerecorded1;
  }

  @Input() datosUser1!: boolean;
  @Input() datosContent1!: boolean;
  @Input() datosBooks1!: boolean;
  @Input() datosExercises1!: boolean;
  @Input() datosClass1!: boolean;
  @Input() datosPrerecorded1!: boolean;
  
  user!: boolean;
  constructor(private compartidoServiceService:CompartidoServiceService){
    this.user = this.compartidoServiceService.getData();
  }

  @Output() activateSectionUsers = new EventEmitter<boolean>();
  @Output() activateSectionContents = new EventEmitter<boolean>();
  @Output() activateSectionBooks = new EventEmitter<boolean>();
  @Output() activateSectionExercises = new EventEmitter<boolean>();
  @Output() activaSectionClasses = new EventEmitter<boolean>();
  @Output() activaSectionPrerecordeds = new EventEmitter<boolean>();

  datosUser = false;
  datosContent = false;
  datosBooks = false;
  datosExercise = false;
  datosClass = false;
  datosPrerecorded = false;

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

  activateSectionBook(){
    this.activateSectionBooks.emit(this.datosBooks = !this.datosBooks);
  }

  activateSectionExercise(){
    this.activateSectionExercises.emit(this.datosExercise = !this.datosExercise);
  }
  
  activateSectionClass(){
    this.activaSectionClasses.emit(this.datosClass = !this.datosClass);
  }

  activateSectionPrerecorded(){
    this.activaSectionPrerecordeds.emit(this.datosPrerecorded = !this.datosPrerecorded);
    console.log("prerecorded")
  }

} 
