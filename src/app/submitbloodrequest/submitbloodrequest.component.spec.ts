import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitbloodrequestComponent } from './submitbloodrequest.component';

describe('SubmitbloodrequestComponent', () => {
  let component: SubmitbloodrequestComponent;
  let fixture: ComponentFixture<SubmitbloodrequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubmitbloodrequestComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SubmitbloodrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
