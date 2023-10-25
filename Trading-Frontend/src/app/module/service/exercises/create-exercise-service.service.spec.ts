import { TestBed } from '@angular/core/testing';

import { CreateExerciseServiceService } from './create-exercise-service.service';

describe('CreateExerciseServiceService', () => {
  let service: CreateExerciseServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateExerciseServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
