import { TestBed } from '@angular/core/testing';

import { BlockListDataService } from './blocklist-data.service';

describe('BlockListDataService', () => {
  let service: BlockListDataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BlockListDataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
