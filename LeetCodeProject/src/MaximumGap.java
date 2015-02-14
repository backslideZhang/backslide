import java.util.Arrays;

public class MaximumGap {

    public void solution() {
        int[] input = new int[]{3,6,9,1};
        System.out.println(maximumGap(input));
    }

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        int max = num[0];
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(num[i], max);
            min = Math.min(num[i], min);
        }
        int partialGap = (int) Math.ceil(((double) (max - min)) / (num.length - 1));
        int[] partialMax = new int[num.length - 1];
        int[] partialMin = new int[num.length - 1];
        Arrays.fill(partialMax, min);
        Arrays.fill(partialMin, max);
        for (int i = 0; i < num.length; i++) {
            if (num[i] == max) {
                continue;
            }
            int index = (num[i] - min) / partialGap;
            partialMax[index] = Math.max(partialMax[index], num[i]);
            partialMin[index] = Math.min(partialMin[index], num[i]);
        }
        int previousIndex = 0;
        int maxGap = 0;
        for (int i = 1; i < num.length - 1; i++) {
            if (partialMax[i] == min && partialMin[i] == max) {
                continue;
            } else {
                int newGap = partialMin[i] - partialMax[previousIndex];
                maxGap = Math.max(newGap, maxGap);
                previousIndex = i;
            }
        }
        maxGap = Math.max(maxGap, max - partialMax[previousIndex]);
        return maxGap;
    }
}
