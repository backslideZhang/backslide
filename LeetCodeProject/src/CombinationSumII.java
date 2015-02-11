import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CombinationSumII {
	public void solution(){
		System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
	}
	
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		return combinationSum2(num, 0, target);
    }
	
	public List<List<Integer>> combinationSum2(int[] num, int start,int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (target == 0){
			result.add(new LinkedList<Integer>());
			return result;
		}
		for (int i = start; i < num.length; i++){
			if (num[i] <= target){
				List<List<Integer>> sub_result = combinationSum2(num, i+1, target - num[i]);
				for (List<Integer> list : sub_result){
					((LinkedList<Integer>) list).addFirst(num[i]);
					if (!result.contains(list)){
						result.add(list);
					}
				}
			}else{
				break;
			}
		}
		return result;
    }
}
