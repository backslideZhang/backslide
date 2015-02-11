import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GenerateParentheses {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		for (String tmp : generateParenthesis(scan.nextInt())){
			System.out.println(tmp);
		}
		scan.close();
	}
	
	public List<String> generateParenthesis(int n) {
		return iterFunc(0, n, "");
    }
	
	public List<String> iterFunc(int leftnum, int n, String preffix){
		List<String> result = new ArrayList<String>();
		if (n == 0 && leftnum > 0){
			while (leftnum > 0){
				preffix += ")";
				leftnum--;
			}
			result.add(preffix);
			return result;
		}
		if (n > 0 ){
			result.addAll(iterFunc(leftnum+1, n-1, preffix+"("));
		}
		if (leftnum > 0){
			result.addAll(iterFunc(leftnum-1, n, preffix+")"));
		}
		return result;
	}
}
