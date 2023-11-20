import { TestBed } from '@angular/core/testing';

import { ReadFileExerciseService } from './read-file-exercise.service';

describe('ReadFileExerciseService', () => {
  let service: ReadFileExerciseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadFileExerciseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
