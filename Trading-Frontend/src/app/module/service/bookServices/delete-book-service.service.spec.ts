import { TestBed } from '@angular/core/testing';

import { DeleteBookServiceService } from './delete-book-service.service';

describe('DeleteBookServiceService', () => {
  let service: DeleteBookServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteBookServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
