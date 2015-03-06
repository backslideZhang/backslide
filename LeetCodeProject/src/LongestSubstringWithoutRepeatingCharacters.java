import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
    public void solution() {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> chs = new LinkedList<Character>();
        int maxLength = 0;
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chs.contains(ch)) {
                while (chs.poll() != ch) {
                    length--;
                }
                chs.add(ch);
            } else {
                length++;
                if (length > maxLength) {
                    maxLength = length;
                }
                chs.add(ch);
            }
        }
        return maxLength;
    }
}
