import { TestBed } from '@angular/core/testing';

import { ReadUserIdService } from './read-user-id.service';

describe('ReadUserEmailService', () => {
  let service: ReadUserIdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadUserIdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
