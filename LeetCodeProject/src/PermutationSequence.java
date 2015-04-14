import java.util.LinkedList;

public class PermutationSequence {

    public void solution() {
        System.out.println(getPermutation(1,1));
    }

    public String getPermutation(int n, int k) {
        int factor = 1;
        LinkedList<Integer> set = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            factor *= i;
            set.add(i);
        }
        return getPermutation(set, k-1, factor);
    }

    public String getPermutation(LinkedList<Integer> set, int k, int factor) {
        if (set.size() == 1) {
            return ""+set.remove();
        }
        factor = factor / set.size();
        int charPos = k / factor;
        String result = "";
        result += set.remove(charPos);
        k = k % factor;
        return result + "" + getPermutation(set, k, factor);
    }
}
