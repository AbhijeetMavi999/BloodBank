import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonateBloodComponent } from './donate-blood.component';

describe('DonateBloodComponent', () => {
  let component: DonateBloodComponent;
  let fixture: ComponentFixture<DonateBloodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonateBloodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonateBloodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
