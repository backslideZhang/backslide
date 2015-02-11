import java.util.Scanner;


public class NextPermutation {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		String inStr = "";
		inStr += scan.next().trim();
		String[] nums = inStr.split(",");
		int[] num = new int[nums.length];
		for (int i = 0; i < num.length; i++){
			num[i] = Integer.parseInt(nums[i]);
		}
		nextPermutation(num);
		scan.close();
	}

	public void nextPermutation(int[] num) {
		if (num.length == 1){
			printNum(num);
			return;
		}
		int pos;
		for (pos = num.length - 2; pos >= 0; pos--){
			if (num[pos] < num[pos+1]){
				break;
			}
		}
		int length = num.length - pos;
		if (pos >= 0){
			int pos_tmp = pos + 1;
			for (int i = pos_tmp + 1; i < num.length; i++){
				if (num[pos] < num[i] && num[pos_tmp] >= num[i]){
					pos_tmp = i;
				}
			}
			int tmp = num[pos_tmp];
			num[pos_tmp] = num[pos];
			num[pos] = tmp;
		}
		int[] result = (int[]) num.clone();
		for (int i = 0; i < length - 1; i++){
			num[num.length - 1 - i] = result[pos + 1 + i];
		}
		printNum(num);
	}
	
	public void printNum(int[] num) {
		for (int i = 0; i < num.length - 1; i++){
			System.out.print(num[i]+",");
		}
		System.out.println(num[num.length-1]);
	}
	
	/*if (num.length == 1){
		return;
	}
	int pos;
	for (pos = num.length - 2; pos >= 0; pos--){
		if (num[pos] < num[pos+1]){
			break;
		}
	}
	int length = num.length - pos;
	if (pos >= 0){
		int pos_tmp = pos + 1;
		for (int i = pos_tmp + 2; i < num.length; i++){
			if (num[pos] < num[i] && num[pos_tmp] >= num[i]){
				pos_tmp = i;
			}
		}
		int tmp = num[pos_tmp];
		num[pos_tmp] = num[pos];
		num[pos] = tmp;
	}
	int[] result = (int[]) num.clone();
	for (int i = 0; i < length - 1; i++){
		num[num.length - 1 - i] = result[pos + 1 + i];
	}*/
}
