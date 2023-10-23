import { TestBed } from '@angular/core/testing';

import { ReadExercisesServiceService } from './read-exercises-service.service';

describe('ReadExercisesServiceService', () => {
  let service: ReadExercisesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadExercisesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
