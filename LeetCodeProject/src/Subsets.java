import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {

    public void solution() {
        System.out.println(subsets(new int[]{1,2}));
    }

    public List<List<Integer>> subsets(int[] S) {
        int[] mark = new int[S.length];
        Arrays.sort(S);
        return subsets(S, mark, S.length);
    }

    public List<List<Integer>> subsets(int[] S, int[] mark, int k) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        int[] tmp = mark.clone();
        if (k == 0) {
            results.add(new LinkedList<Integer>());
            return results;
        } else if (k > 0) {
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == 0) {
                    tmp[i] = 1;
                    List<List<Integer>> subResults = subsets(S, tmp, k-1);
                    if (subResults != null && !subResults.isEmpty()) {
                        for (List<Integer> subResult : subResults) {
                            results.add(new LinkedList(subResult));
                            ((LinkedList<Integer>) subResult).addFirst(S[i]);
                            results.add(subResult);
                        }
                    }
                }
            }
            return results;
        } else {
            return null;
        }
    }
}
