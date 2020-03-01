import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhonebookentryComponent } from './phonebookentry.component';

describe('PhonebookentryComponent', () => {
  let component: PhonebookentryComponent;
  let fixture: ComponentFixture<PhonebookentryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhonebookentryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhonebookentryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
