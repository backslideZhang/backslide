import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public void solution() {
        System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        List<Integer> result = new LinkedList<Integer>();
        List<Integer> preResult = new LinkedList<Integer>();
        if (num.length < 3) {
            return results;
        }
        Arrays.sort(num);
        for (int i = num.length - 1; i > 1; i--) {
            if (i < num.length - 1 && num[i] == num[i + 1]) {
                continue;
            }
            int l = 0;
            int r = i-1;
            if (num[i] + num[i-1] + num[i-2] < 0) {
                break;
            }
            if (num[i] + num[0] + num[1] > 0) {
                continue;
            }
            while (l < r) {
                int sum = num[l] + num[r] + num[i];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    if (preResult.size() == 3) {
                        if (preResult.get(0) == num[l] && preResult.get(1) == num[r] && preResult.get(2) == num[i]) {
                            l++;
                            r--;
                            continue;
                        }
                    }
                    result.add(num[l]);
                    result.add(num[r]);
                    result.add(num[i]);
                    results.add(result);
                    preResult = result;
                    result = new LinkedList<Integer>();
                    l++;
                    r--;
                }
            }
        }
        return results;
    }
}
