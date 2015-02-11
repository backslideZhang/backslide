import java.util.Scanner;

public class PalindromePartitioningII {

    public void solution() {
        Scanner scan = new Scanner(System.in);
        String inStr = "";
        inStr += scan.next().trim();
        System.out.println(minCut(inStr));
        scan.close();
    }

    private int minCut(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int length = s.length();
        boolean[][] isPalindromeMatrix = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindromeMatrix[i][i] = true;
        }
        int[] minCutMatrix = new int[length];
        minCutMatrix[0] = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < length - j; i++) {
                int l = i + j;
                isPalindromeMatrix[i][l] = (s.charAt(i) == s.charAt(l));
                if (j > 1) {
                    isPalindromeMatrix[i][l] = isPalindromeMatrix[i][l] && isPalindromeMatrix[i+1][l-1];
                }
            }
        }
        for (int j = 1; j < length; j++) {
            int minValue = length;
            if (isPalindromeMatrix[0][j]) {
                minCutMatrix[j] = 0;
                continue;
            }
            for (int i = 0; i < j; i++) {
                if (isPalindromeMatrix[i + 1][j]) {
                    minValue = Math.min(minValue, minCutMatrix[i] + 1);
                }
            }
            minCutMatrix[j] = minValue;
        }
        return minCutMatrix[length-1];
    }
}
