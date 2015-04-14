import java.util.Scanner;

public class BaiduQuestion1 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int caseNum = Integer.parseInt(scan.nextLine());
        String[] cases = new String[caseNum];
        for (int i = 0; i < caseNum; i++) {
            cases[i] = scan.nextLine();
        }
        for (int i = 0; i < caseNum; i++) {
            translate(cases[i]);
        }
    }

    private static void translate(String input) {
        if (input.length() == 0) {
            System.out.println("0");
            return;
        }
        char pre = input.charAt(0);
        int count = 1;
        if (pre >= 'A' && pre <= 'Z') {
            pre = (char) (pre - 'A' + 'a');
            count++;
        }
        int result = 0;
        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == pre) {
                count++;
            } else if ((ch - 'A' + 'a') == pre) {
                count += 2;
            } else {
                result += count * count * (pre - 'a' + 1);
                pre = input.charAt(i);
                count = 1;
                if (pre >= 'A' && pre <= 'Z') {
                    pre = (char) (pre - 'A' + 'a');
                    count++;
                }
            }
        }
        result += count * count * (pre - 'a' + 1);
        System.out.println(result);
    }
}
