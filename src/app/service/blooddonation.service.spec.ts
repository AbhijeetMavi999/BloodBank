import { TestBed } from '@angular/core/testing';

import { BlooddonationService } from './blooddonation.service';

describe('BlooddonationService', () => {
  let service: BlooddonationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BlooddonationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
