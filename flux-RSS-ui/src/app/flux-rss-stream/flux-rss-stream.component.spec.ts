import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FluxRssStreamComponent } from './flux-rss-stream.component';

describe('FluxRssStreamComponent', () => {
  let component: FluxRssStreamComponent;
  let fixture: ComponentFixture<FluxRssStreamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FluxRssStreamComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FluxRssStreamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
