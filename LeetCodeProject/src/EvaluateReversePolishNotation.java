
public class EvaluateReversePolishNotation {
	public void solution(){
		System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
	}
	
	public int evalRPN(String[] tokens) {
		return evalRPNwithPos(tokens, tokens.length-1)[0];
    }
	
	public int[] evalRPNwithPos(String[] tokens, int pos){
		boolean flag = false;
		int[] result = new int[2];
		try{
			int num = Integer.parseInt(tokens[pos]);
			result[0] = num;
			result[1] = 1;
		}catch(NumberFormatException e){
			flag = true;
		}
		if (flag){
			int[] tmp1 = evalRPNwithPos(tokens, pos-1);
			int[] tmp2 = evalRPNwithPos(tokens, pos-1-tmp1[1]);
			result[1] = tmp2[1] + tmp1[1] + 1;
			if(tokens[pos].equals("+")){
				result[0] = tmp2[0]+tmp1[0];
			}else if(tokens[pos].equals("-")){
				result[0] = tmp2[0]-tmp1[0];
			}else if(tokens[pos].equals("*")){
				result[0] = tmp2[0]*tmp1[0];
			}else if(tokens[pos].equals("/")){
				result[0] = tmp2[0]/tmp1[0];
			}
		}
		return result;
	}
	
}
