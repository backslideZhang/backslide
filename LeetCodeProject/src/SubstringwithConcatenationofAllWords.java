import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

    public void solution() {
        System.out.println(findSubstring("a", new String[]{"a"}));
    }

    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if (S == null || L == null || L.length <= 0) {
            return null;
        }
        int Llength = L.length;
        int wordLength = L[0].length();
        Map<String, Integer> LMap = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            Integer old = LMap.get(L[i]);
            if (old == null) {
                LMap.put(L[i], 1);
            } else {
                LMap.put(L[i], old + 1);
            }
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <= S.length() - Llength * wordLength; i++) {
            int k = 0;
            map.clear();
            for (int j = i; j - i < Llength * wordLength; j += wordLength) {
                String temp = S.substring(j, j + wordLength);
                Integer Lint = LMap.get(temp);
                if (Lint == null) {
                    break;
                }
                Integer old = map.get(temp);
                if (old == null) {
                    map.put(temp, 1);
                } else {
                    map.put(temp, old + 1);
                    if (old + 1 > Lint) {
                        break;
                    }
                }
                k++;
            }
            if (k == Llength) {
                result.add(i);
            }
        }
        return result;
    }
}
