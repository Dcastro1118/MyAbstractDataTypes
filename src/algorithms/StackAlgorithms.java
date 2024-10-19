package algorithms;

import structures.stack.ArrayStack;
import structures.stack.Stack;
 
public class StackAlgorithms {


    public static String reverseString(String string){
        ArrayStack<Character> stringStack = new ArrayStack<>();
        char [] charArray = string.toCharArray();
        for (int i = 0; i < string.length(); i++){
            stringStack.push(charArray[i]);
        }
        for (int i = 0; i < string.length(); i++){
            charArray[i] = stringStack.pop();
        }
        return new String(charArray);
    }

    public boolean balancedParentheses(String parentheses){
        char[] parenthesesArray = parentheses.toCharArray();
        Stack<Character> stack = new Stack<>();
        char top;
        for (char c : parenthesesArray) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                top = stack.pop();
                if (top == '[' && c != ']' || top == '(' && c != ')' || top == '{' && c != '}'){
                    return false;
                }
            }

        }
        return true;
    }



}
