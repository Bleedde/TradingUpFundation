import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StartAComponent } from './start-a.component';

describe('StartAComponent', () => {
  let component: StartAComponent;
  let fixture: ComponentFixture<StartAComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StartAComponent]
    });
    fixture = TestBed.createComponent(StartAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
