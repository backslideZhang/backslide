import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BaiduQuestion4 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int caseNum = scan.nextInt();
        for (int i = 0; i < caseNum; i++) {
            int charNum = scan.nextInt();
            Map<Character, Integer> selectChars = new HashMap<Character, Integer>();
            for (int j = 0; j < charNum; j++) {
                char next = scan.next().charAt(0);
                if (selectChars.containsKey(next)) {
                    selectChars.put(next, selectChars.get(next)+1);
                } else {
                    selectChars.put(next, 1);
                }
            }
            scan.nextLine();
            int pNum = 0;
            String str = scan.nextLine();
            Map<Character, Integer> copyChars = new HashMap<Character, Integer>(selectChars);
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (copyChars.containsKey(ch)) {
                    int count = copyChars.get(ch);
                    if (count > 1) {
                        copyChars.put(ch, count-1);
                    } else {
                        copyChars.remove(ch);
                    }
                    if (copyChars.isEmpty()) {
                        pNum++;
                        copyChars = new HashMap<Character, Integer>(selectChars);
                    }
                }
            }
            System.out.println(pNum);
        }
    }
}
