import { TestBed } from '@angular/core/testing';

import { ReadExerciseServiceService } from './read-exercise-service.service';

describe('ReadExerciseServiceService', () => {
  let service: ReadExerciseServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadExerciseServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
