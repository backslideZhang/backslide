import java.util.Arrays;
import java.util.Scanner;


public class ThreeSumClosest {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		String inStr = "";
		inStr += scan.next().trim();
		String[] nums = inStr.split(",");
		int[] num = new int[nums.length - 1];
		for (int i = 0; i < num.length; i++){
			num[i] = Integer.parseInt(nums[i]);
		}
		System.out.println(threeSumClosest(num, Integer.parseInt(nums[nums.length-1])));
		scan.close();
	}
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int sum = num[0] + num[1] + num[2];
        if (sum == target) {
            return sum;
        }
		for (int i = 0; i < num.length; i++) {
            int j = i+1;
            int k = num.length - 1;
            while(j < k) {
                int newSum = num[i] + num[j] + num[k];
                if (newSum == target) {
                    return newSum;
                }
                if (newSum < target) {
                    j++;
                }
                if (newSum > target) {
                    k--;
                }
                if (Math.abs(target - sum) > Math.abs(target - newSum)) {
                    sum = newSum;
                }
            }
		}
		return sum;
	}
}
