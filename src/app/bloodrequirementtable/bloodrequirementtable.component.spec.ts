import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodrequirementtableComponent } from './bloodrequirementtable.component';

describe('BloodrequirementtableComponent', () => {
  let component: BloodrequirementtableComponent;
  let fixture: ComponentFixture<BloodrequirementtableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodrequirementtableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodrequirementtableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
