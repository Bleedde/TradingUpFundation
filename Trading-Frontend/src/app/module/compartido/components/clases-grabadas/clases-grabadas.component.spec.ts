import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClasesGrabadasComponent } from './clases-grabadas.component';

describe('ClasesGrabadasComponent', () => {
  let component: ClasesGrabadasComponent;
  let fixture: ComponentFixture<ClasesGrabadasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClasesGrabadasComponent]
    });
    fixture = TestBed.createComponent(ClasesGrabadasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
