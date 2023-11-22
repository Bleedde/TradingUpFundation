import { TestBed } from '@angular/core/testing';

import { ReadExerciseSolutionServiceService } from './read-exercise-solution-service.service';

describe('ReadExerciseSolutionServiceService', () => {
  let service: ReadExerciseSolutionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadExerciseSolutionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
