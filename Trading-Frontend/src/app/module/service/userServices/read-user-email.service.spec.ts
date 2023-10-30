import { TestBed } from '@angular/core/testing';

import { ReadUserEmailService } from './read-user-email.service';

describe('ReadUserEmailService', () => {
  let service: ReadUserEmailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadUserEmailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
