import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Solution {
	public static String questionName = "WordLadderII";
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class question = Class.forName(questionName);
		Object ob = question.newInstance();
		Method method = question.getMethod("solution", new Class[0]);
		method.invoke(ob, new Object[0]);
	}
}
