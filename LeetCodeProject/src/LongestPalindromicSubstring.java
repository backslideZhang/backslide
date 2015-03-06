public class LongestPalindromicSubstring {
    public void solution() {
        System.out.println(longestPalindrome("abcbaaaaaa"));
    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[1000][1000];
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >=0; j--) {
                if (i - j <= 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i-1][j+1];
                }
                if (dp[i][j]) {
                    if (i - j > end - start) {
                        end = i;
                        start = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
