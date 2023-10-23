import { TestBed } from '@angular/core/testing';

import { UpdateBookServiceService } from './update-book-service.service';

describe('UpdateBookServiceService', () => {
  let service: UpdateBookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateBookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
