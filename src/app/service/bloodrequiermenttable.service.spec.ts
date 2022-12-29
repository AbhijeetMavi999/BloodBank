import { TestBed } from '@angular/core/testing';

import { BloodrequiermenttableService } from './bloodrequiermenttable.service';

describe('BloodrequiermenttableService', () => {
  let service: BloodrequiermenttableService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BloodrequiermenttableService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
