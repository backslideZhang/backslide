import java.util.Stack;

public class LongestValidParentheses {

    public void solution() {
        System.out.println(longestValidParentheses("())()()(()"));
        //()(()
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        int cur = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cur++;
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                    leftCount = 0;
                }
            }
        }
        if (leftCount > 0) {
            max = Math.max(max, cur - leftCount);
        }
        return max;
    }
}
