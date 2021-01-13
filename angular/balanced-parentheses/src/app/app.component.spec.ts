import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let component: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
    fixture = TestBed.createComponent(AppComponent);
    component = fixture.componentInstance;
  });

  it('should create the app', () => {
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'balanced-parentheses'`, () => {
    const app = fixture.componentInstance;
    expect(app.title).toEqual('balanced-parentheses');
  });

  it('should return String is balanced when button is clicked', async(() => {
    let p = fixture.debugElement.nativeElement.querySelector('p');
  
    component.inputString = "tes[]t";
    component.validateString();
    fixture.detectChanges();
  
    fixture.whenStable().then(() => {
      expect(component.clickMessage).toBe('String is balanced');
      expect(p.textContent).toBe('String is balanced');
    });
  })); 

  it('should return String is not balanced when button is clicked', async(() => {
    let p = fixture.debugElement.nativeElement.querySelector('p');
  
    component.inputString = "test[](){";
    component.validateString();
    fixture.detectChanges();
  
    fixture.whenStable().then(() => {
      expect(component.clickMessage).toBe('String is not balanced');
      expect(p.textContent).toBe('String is not balanced');
    });
  })); 
});
