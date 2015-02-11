

public class MaximalRectangle {
	public void solution(){
//		Scanner scan = new Scanner(System.in);
		System.out.println(maximalRectangle(new char[][]{
			new char[]{'0','1','1'},
			new char[]{'1','0','1'},
			new char[]{'1','1','1'}
		}));
//		scan.close();
	}
	public int maximalRectangle(char[][] matrix) {
		int height = matrix.length;
		if (height == 0){
			return 0;
		}
		int width = matrix[0].length;
		if (width == 0){
			return 0;
		}
		int maxArea = 0;
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				if (matrix[i][j] == '1'){
					int tmp = getArea(matrix, i, j);
					if (tmp > maxArea){
						maxArea = tmp;
					}
				}
			}
		}
		return maxArea;
    }
	private int getArea(char[][] matrix, int i, int j) {
		int k_max = matrix.length;
		int l_max = matrix[0].length;
		int curArea = 0;
		int k,l;
		int tmp;
		for (k = i; k < k_max; k++){
			for (l = j; l < l_max; l++){
				if (matrix[k][l] == '1'){
					continue;
				}else{
					break;
				}
			}
			tmp = (k-i+1)*(l-j);
			curArea = tmp > curArea ? tmp : curArea;
			l_max = l;
		}
		return curArea;
	}
}
