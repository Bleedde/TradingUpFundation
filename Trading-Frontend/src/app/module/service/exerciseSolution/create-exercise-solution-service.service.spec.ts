import { TestBed } from '@angular/core/testing';

import { CreateExerciseSolutionServiceService } from './create-exercise-solution-service.service';

describe('CreateExerciseSolutionServiceService', () => {
  let service: CreateExerciseSolutionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateExerciseSolutionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
