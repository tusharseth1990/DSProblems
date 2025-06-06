package stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//Time complexity: O(n) where n = length of string.
//        Space complexity: O(n)
public class BalancedBrackets { 
	  
    // function to check if brackets are balanced 
    static boolean areBracketsBalanced(String expr) 
    {
        if (expr.length() % 2 != 0) return false;
        // Using ArrayDeque is faster than using Stack class 
        Deque<Character> stack 
            = new ArrayDeque<>(); 
  
        // Traversing the Expression 
        for (int i = 0; i < expr.length(); i++)  
        { 
            char x = expr.charAt(i); 
  
            if (x == '(' || x == '[' || x == '{')  
            { 
                // Push the element in the stack 
                stack.push(x); 
                continue; 
            } 
  
            // IF current current character is not opening 
            // bracket, then it must be closing. So stack 
            // cannot be empty at this point. 
            if (stack.isEmpty()) 
                return false; 
            char check;

            switch (x) {
                case ')' -> {
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                }
                case '}' -> {
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                }
                case ']' -> {
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                }
            }
        } 
  
        // Check Empty Stack 
        return (stack.isEmpty()); 
    }




    public boolean isValid(String s) {


        // Create a new stack to store the characters.
        Stack<Character> stack = new Stack<>();


        // convert string into char array and access the characters using for each loop.
        for(char ch: s.toCharArray())
        {
            // check ch
            switch (ch)
            {
                // open bracket then push it in stack.
                // close bracket then pop the item and compare.
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(')

                    // if the stack is empty then it means string have no open bracket.
                    // hence it is invalid.
                    {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                    {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[')
                    {
                        return false;
                    }
                    break;
            }
        }


        // After the loop we have to check one more condition.
        // return true only if the stack is empty.
        // if stack is not empty that means we have unused brackets.

        return stack.isEmpty();

    }

    // Driver code 
    public static void main(String[] args) 
    { 
        String expr = "([{}])"; 
  
        // Function call 
        if (areBracketsBalanced(expr)) 
            System.out.println("Balanced "); 
        else
            System.out.println("Not Balanced "); 
    } 
} 
