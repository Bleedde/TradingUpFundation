import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EjerciciosClaseComponent } from './ejercicios-clase.component';

describe('EjerciciosClaseComponent', () => {
  let component: EjerciciosClaseComponent;
  let fixture: ComponentFixture<EjerciciosClaseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EjerciciosClaseComponent]
    });
    fixture = TestBed.createComponent(EjerciciosClaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
