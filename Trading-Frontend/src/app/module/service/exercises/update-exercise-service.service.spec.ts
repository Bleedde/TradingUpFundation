import { TestBed } from '@angular/core/testing';

import { UpdateExerciseServiceService } from './update-exercise-service.service';

describe('UpdateExerciseServiceService', () => {
  let service: UpdateExerciseServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateExerciseServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
