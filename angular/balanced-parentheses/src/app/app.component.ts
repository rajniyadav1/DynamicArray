import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'balanced-parentheses';
  inputString: string;
  clickMessage = '';

  validateString() {
    this.clickMessage = '';
    let stack = [], str = this.inputString;
    console.log(str);
    let map = {
        '(': ')',
        '[': ']',
        '{': '}'
    }

    for (let i = 0; i < str.length; i++) {
     
      // If character is an opening brace add it to a stack
        if (str[i] === '(' || str[i] === '{' || str[i] === '[' ) {
            stack.push(str[i]);
        }
        //  If that character is a closing brace, pop from the stack, which will also reduce the length of the stack each time a closing bracket is encountered.
        else {
            let last = stack.pop();
            if (str[i] === ')' || str[i] === '}' || str[i] === ']' ) {
              if (str[i] !== map[last]) {
                return this.clickMessage = "String is not balanced";;
               }  
          }
        }
    }
    if(stack.length==0){
      return this.clickMessage = "String is balanced";; 
    }
    return this.clickMessage = "String is not balanced";
  }
}