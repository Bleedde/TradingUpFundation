import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlideVarComponent } from './slide-var.component';

describe('SlideVarComponent', () => {
  let component: SlideVarComponent;
  let fixture: ComponentFixture<SlideVarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlideVarComponent]
    });
    fixture = TestBed.createComponent(SlideVarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
