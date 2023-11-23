import { TestBed } from '@angular/core/testing';

import { ReadExercisesSolutionServiceService } from './read-exercises-solution-service.service';

describe('ReadExercisesSolutionServiceService', () => {
  let service: ReadExercisesSolutionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadExercisesSolutionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
