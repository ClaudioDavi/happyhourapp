import { TestBed, inject } from '@angular/core/testing';
import { Item } from './item';
import { ItemDataService } from './item-data.service';

describe('ItemDataService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ItemDataService]
    });
  });
});
