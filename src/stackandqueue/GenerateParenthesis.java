package stackandqueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
//o(4^n/sqrt n)
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis sol = new GenerateParenthesis();
        sol.generateParenthesis(3);
    }

    public List<String> generateParenthesis ( int n){
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    private void backtrack ( int openN, int closedN, int n, List<String > res, StringBuilder stack){
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }



    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesisII(int n) {
        backtrackII(0, 0, n);
        return res;
    }

    private void backtrackII(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrackII(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrackII(openN, closedN + 1, n);
            stack.pop();
        }


    }
}