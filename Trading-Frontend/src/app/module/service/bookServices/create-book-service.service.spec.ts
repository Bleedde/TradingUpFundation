import { TestBed } from '@angular/core/testing';

import { CreateBookServiceService } from './create-book-service.service';

describe('CreateBookServiceService', () => {
  let service: CreateBookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateBookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
