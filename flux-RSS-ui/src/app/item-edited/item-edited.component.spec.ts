import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemEditedComponent } from './item-edited.component';

describe('ItemEditedComponent', () => {
  let component: ItemEditedComponent;
  let fixture: ComponentFixture<ItemEditedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemEditedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemEditedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
