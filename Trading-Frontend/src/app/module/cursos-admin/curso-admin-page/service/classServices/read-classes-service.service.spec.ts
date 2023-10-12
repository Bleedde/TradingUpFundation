import { TestBed } from '@angular/core/testing';

import { ReadClassesServiceService } from './read-classes-service.service';

describe('ReadClassesServiceService', () => {
  let service: ReadClassesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadClassesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
