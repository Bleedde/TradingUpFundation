import { TestBed } from '@angular/core/testing';

import { ReadBooksServiceService } from './read-books-service.service';

describe('ReadBooksServiceService', () => {
  let service: ReadBooksServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadBooksServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
