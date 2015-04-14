import java.util.Scanner;
import java.util.Stack;

public class BaiduQuestion3 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int caseNum = scan.nextInt();
        for (int i = 0; i < caseNum; i++) {
            int seqLen = scan.nextInt();
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j < seqLen; j++) {
                int next = scan.nextInt();
                while (stack.contains(next)) {
                    stack.pop();
                }
                stack.push(next);
            }
            if (stack.isEmpty()) {
                break;
            } else {
                System.out.print(stack.pop());
            }
            while (!stack.isEmpty()) {
                System.out.print("->" + stack.pop());
            }
            System.out.println("");
        }
    }
}
