
public class Candy {
	public void solution(){
		System.out.println(candy(new int[]{58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89}));
	}
	
	public int candy(int[] ratings) {
		if (ratings.length <= 0){
			return 0;
		}
		if (ratings.length == 1){
			return 1;
		}
		int length = ratings.length;
		int[] candies = new int[length];
		if (ratings[0] <= ratings[1]){
			candies[0] = 1;
		}
		if (ratings[length-1] <= ratings[length-2]){
			candies[length-1] = 1;
		}
		for (int i = 1; i < length - 1; i++){
			if (ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i+1]){
				candies[i] = 1;
			}else if (ratings[i] > ratings[i-1] && candies[i-1] != 0){
				candies[i] = candies[i-1]+1;
			}
		}
		for (int i = length-2; i > 0; i--){
			if (ratings[i] > ratings[i+1] && candies[i+1] != 0){
				candies[i] = Math.max(candies[i],candies[i+1]+1);
			}
		}
		if (ratings[0] > ratings[1]){
			candies[0] = candies[1]+1;
		}
		if (ratings[length-1] > ratings[length-2]){
			candies[length-1] = candies[length-2]+1;
		}
		int total = 0;
		for (int i = 0; i < length; i++){
			total += candies[i];
		}
		return total;
    }
}
