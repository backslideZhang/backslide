import java.util.Arrays;

public class ZigZagConversion {

    public void solution() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        int part = (int) Math.ceil((double) s.length() / (double) (2*nRows-2));
        String[] result = new String[nRows];
        Arrays.fill(result, "");
        for (int i = 0; i < part; i++) {
            for (int j = 0; j < nRows * 2 - 2; j++) {
                if (i * (2*nRows - 2) + j >= s.length()) {
                    break;
                }
                char ch = s.charAt(i * (2*nRows - 2) + j);
                if (j < nRows - 1) {
                    int row = j;
                    int col = i * (nRows - 1);
                    result[row] += ch;
                } else {
                    int col = j - nRows + 1 + i * (nRows - 1);
                    int row = 2 * nRows - 2 - j;
                    result[row] += ch;
                }
            }
        }
        String resultStr = "";
        for (int i = 0; i < nRows; i++) {
            resultStr += result[i];
        }
        return resultStr;
    }
}
