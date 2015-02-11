import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FourSum {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		String inStr = "";
		inStr += scan.next().trim();
		String[] nums = inStr.split(",");
		int[] num = new int[nums.length - 1];
		for (int i = 0; i < num.length; i++){
			num[i] = Integer.parseInt(nums[i]);
		}
		fourSum(num, Integer.parseInt(nums[nums.length-1]));
		scan.close();
	}
	
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (num.length <= 3){
			return result;
		}
		Arrays.sort(num);
		int threeMin = target - num[num.length-1];
		int twoMin = threeMin - num[num.length-2];
		int oneMin = twoMin - num[num.length-3];
		int threeMax = target - num[0];
		int twoMax = threeMax - num[1];
		int oneMax = twoMax - num[2];
		for (int i = 0; i < num.length; i++){
			if (num[i] > oneMax){
				break;
			}
			if (num[i] < oneMin){
				continue;
			}
			for (int j = i+1; j < num.length; j++){
				if (num[i] + num[j] > twoMax){
					break;
				}
				if (num[i] + num[j] < twoMin){
					continue;
				}
				for (int k = j+1; k < num.length; k++){
					int result_ijk = num[i] + num[j] + num[k];
					if (result_ijk > threeMax){
						break;
					}
					if (result_ijk < threeMin){
						continue;
					}
					for (int l = k+1; l < num.length; l++){
						if (result_ijk + num[l] < target){
							continue;
						}
						if (result_ijk + num[l] == target){
							List<Integer> fourNum = new ArrayList<Integer>();
							fourNum.add(num[i]);
							fourNum.add(num[j]);
							fourNum.add(num[k]);
							fourNum.add(num[l]);
							if (!result.contains(fourNum)){
								result.add(fourNum);
							}
						}else{
							break;
						}
					}
				}
			}
		}
		return result;
    }
}
