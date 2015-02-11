

public class PlusOne {
	public void solution(){
		System.out.println(plusOne(new int[]{}));
	}
	
	public int[] plusOne(int[] digits) {
		int[] result1 = digits.clone();
		int[] result2 = new int[digits.length+1];
		for (int i = digits.length-1; i>=0; i--){
			result1[i]++;
			if (i != 0 && result1[i] > 9){
				result1[i] = 0;
				result2[i+1] = 0;
			}else{
				break;
			}
		}
		if (result1[0] > 9){
			result2[0] = 1;
			result2[1] = 0;
			return result2;
		}else{
			return result1;
		}
    }
}
