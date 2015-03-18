import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char stackCh = stack.pop();
                    if (ch == ')' && stackCh != '(') {
                        return false;
                    }
                    if (ch == ']' && stackCh != '[') {
                        return false;
                    }
                    if (ch == '}' && stackCh != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
