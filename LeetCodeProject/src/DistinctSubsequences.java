

public class DistinctSubsequences {
	public void solution(){
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}
	
	public int numDistinct(String S, String T) {
		if (S.length() < T.length() || T.length() <= 0){
			return 0;
		}
		int[][] map = new int[T.length()][S.length()];
		for (int i = 0; i < T.length(); i++){
			for (int j = 0; j < S.length(); j++){
				if (j < i){
					map[i][j] = 0;
					continue;
				}
				if (T.charAt(i) != S.charAt(j)){
					if (j != 0){
						map[i][j] = map[i][j - 1];
					}else{
						map[i][j] = 0;
					}
				}else{
					if (j != 0){
						if (i != 0){
							map[i][j] = map[i - 1][j - 1] + map[i][j - 1];
						}else{
							map[i][j] = map[i][j - 1] + 1;
						}
					}else{
						map[i][j] = 1;
					}
				}
			}
		}
        return map[T.length()-1][S.length()-1];
    }
}
