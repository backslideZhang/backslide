import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {
    public void solution() {
        System.out.println(permuteUnique(new int[]{-1, -1, 3, -1}));
    }
    public List<List<Integer>> permuteUnique(int[] num) {
        return permute(num, 0);
    }

    public List<List<Integer>> permute(int[] num, int start) {
        int[] tmp_num = num.clone();
        List<Integer> usedHead = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (start == tmp_num.length-1) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(tmp_num[start]);
            result.add(list);
        } else {
            for (int i = start; i < tmp_num.length; i++) {
                swap(tmp_num, i, start);
                if (!usedHead.contains(tmp_num[start])) {
                    usedHead.add(tmp_num[start]);
                    List<List<Integer>> sub_result = permute(tmp_num, start+1);
                    for (List<Integer> list : sub_result) {
                        ((LinkedList<Integer>)list).addFirst(tmp_num[start]);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public void swap(int[] num, int pos1, int pos2) {
        if (pos1 != pos2) {
            int tmp = num[pos1];
            num[pos1] = num[pos2];
            num[pos2] = tmp;
        }
    }
}
