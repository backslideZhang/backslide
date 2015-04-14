public class MinimumWindowSubstring {

    public void solution() {
        System.out.println(minWindow("bba","ab"));
    }

    public String minWindow(String S, String T) {
        String result = "";
        int beginPos = -1;

        int[] TCount = new int[128];
        int[] curCount = new int[128];
        int countRemain = T.length();
        for (int i = 0; i < T.length(); i++) {
            TCount[T.charAt(i)]++;
        }
        for (int i = 0; i < S.length(); i++) {
            int Tpos = S.charAt(i);
            if (TCount[Tpos] == 0) {
                continue;
            }
            curCount[Tpos]++;
            if (curCount[Tpos] <= TCount[Tpos]) {
                countRemain--;
                if (countRemain <= 0) {
                    for (int j = beginPos+1; j <= i; j++) {
                        int TbeginPos = S.charAt(j);
                        if (TCount[TbeginPos] == 0) {
                            continue;
                        }
                        if (curCount[TbeginPos] > TCount[TbeginPos]) {
                            curCount[TbeginPos]--;
                            continue;
                        } else {
                            curCount[TbeginPos]--;
                            countRemain++;
                        }
                        int curLength = i - j + 1;
                        if (result.isEmpty()) {
                            result = S.substring(j, i+1);
                        } else if (curLength < result.length()) {
                            result = S.substring(j, i+1);
                        }
                        beginPos = j;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
