import java.lang.reflect.Method;
import java.util.Scanner;

public class Solution {
	public static String questionName = "baidu.Question1";
	
//	public static void main(String[] args) throws Exception {
//		Class question = Class.forName(questionName);
//		Object ob = question.newInstance();
//		Method method = question.getMethod("solution", new Class[0]);
//        method.invoke(ob, new Object[0]);
//	}

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
        StringBuffer sb = new StringBuffer(input);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - 'A' + 'a');
                sb.replace(i,i+1,ch  + "" + ch);
            }
        }
        String lowCaseStr = sb.toString();
        if (lowCaseStr.length() == 0) {
            System.out.println("0");
            return;
        }
        char pre = lowCaseStr.charAt(0);
        int result = 0;
        int count = 1;
        for (int i = 1; i < lowCaseStr.length(); i++) {
            if (lowCaseStr.charAt(i) == pre) {
                count++;
            } else {
                result += count * count * (pre - 'a' + 1);
                pre = lowCaseStr.charAt(i);
                count = 1;
            }
        }
        result += count * count * (pre - 'a' + 1);
        System.out.println(result);
    }
}
