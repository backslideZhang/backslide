import java.util.Stack;


public class ReverseWordsInAString {
	public void solution(){
		System.out.println(reverseWords(" the   sky   is   blue "));
	}
	
	public String reverseWords(String s) {
		Stack<String> stack = new Stack<String>();
		String[] words = s.trim().split(" ");
		for (int i = 0; i < words.length; i++){
			if (words[i].length() > 0){
				stack.push(words[i]);
			}
		}
		String result = "";
		while(!stack.isEmpty()){
			result += stack.pop() + " ";
		}
		return result.trim();
    }
}
