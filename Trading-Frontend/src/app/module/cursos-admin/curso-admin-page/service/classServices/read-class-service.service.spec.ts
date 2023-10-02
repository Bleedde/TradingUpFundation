import { TestBed } from '@angular/core/testing';

import { ReadClassServiceService } from './read-class-service.service';

describe('ReadClassServiceService', () => {
  let service: ReadClassServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadClassServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
