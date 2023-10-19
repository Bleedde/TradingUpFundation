import { TestBed } from '@angular/core/testing';

import { ReadBookServiceService } from './read-book-service.service';

describe('ReadBookServiceService', () => {
  let service: ReadBookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadBookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
