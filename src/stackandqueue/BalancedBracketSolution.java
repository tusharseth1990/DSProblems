package stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
//Algorithm
//
//        Initialize a stack S.
//        Process each bracket of the expression one at a time.
//        If we encounter an opening bracket, we simply push it onto the stack. This means we will process it later, let us simply move onto the sub-expression ahead.
//        If we encounter a closing bracket, then we check the element on top of the stack. If the element at the top of the stack is an opening bracket of the same type, then we pop it off the stack and continue processing. Else, this implies an invalid expression.
//        In the end, if we are left with a stack still having elements, then this implies an invalid expression.
public class BalancedBracketSolution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        Map<Character, Character> bracketLookup = new HashMap<>();

        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');

        for (char c : s.toCharArray()) {
            if (bracketLookup.containsKey(c)) {
                if (brackets.size() != 0 && brackets.peek() == bracketLookup.get(c)) {
                    brackets.pop();
                } else {
                    return false;
                }
            } else {
                brackets.push(c);
            }
        }

        if (brackets.size() == 0) return true;
        return false;
    }
}
