import { TestBed } from '@angular/core/testing';

import { DeleteExerciseServiceService } from './delete-exercise-service.service';

describe('DeleteExerciseServiceService', () => {
  let service: DeleteExerciseServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteExerciseServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
