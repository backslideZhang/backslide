import java.util.Arrays;
import java.util.Scanner;


public class SingleNumberII {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		String inStr = "";
		inStr += scan.next().trim();
		String[] nums = inStr.split(",");
		int[] num = new int[nums.length];
		for (int i = 0; i < num.length; i++){
			num[i] = Integer.parseInt(nums[i]);
		}
		System.out.println(singleNumber(num));
		scan.close();
	}
	
	public int singleNumber(int[] A) {
		Arrays.sort(A);
		for (int i = 0; i < A.length - 3; i += 3){
			if (A[i] != A[i+2]){
				return A[i];
			}
			if (A[i] == A[i+3]){
				return A[i];
			}
		}
		return A[A.length-1];
    }
}
