import java.util.ArrayList;
import java.util.List;


public class RestoreIpAddresses {
	public void solution(){
		System.out.println(restoreIpAddresses("1231231231234"));
	}
	
	public List<String> restoreIpAddresses(String s) {
		return splitByDot(s, 3);
    }
	
	public List<String> splitByDot(String s, int dotNum){
		List<String> result = new ArrayList<String>();
		result.clear();
		if (s.length() > (dotNum+1) * 3){
			return result;
		}
		if (dotNum > 0){
			int minLen = s.length() - 3 * dotNum;
			int maxLen = s.length() - dotNum;
			minLen = minLen > 1 ? minLen : 1;
			maxLen = maxLen < 3 ? maxLen : 3;
			for (int i = minLen; i <= maxLen; i++){
				String preffix = s.substring(0,i);
				String suffix = s.substring(i);
				if (validateString(preffix)){
					List<String> tmpList = mergeString(preffix, splitByDot(suffix, dotNum - 1));
					if (tmpList != null && tmpList.size() > 0){
						result.addAll(tmpList);
					}
				}
			}
		}else{
			if (validateString(s)){
				String str = ""+Integer.parseInt(s);
				if (!result.contains(str)){
					result.add(str);
				}
			}
		}
		return result;
	}
	
	private List<String> mergeString(String preffix, List<String> suffixs){
		if (suffixs == null || suffixs.size() <= 0){
			return null;
		}
		List<String> result = new ArrayList<String>();
		for (String suffix : suffixs){
			String combinedStr = preffix + "." + suffix;
			if (!result.contains(combinedStr)){
				result.add(combinedStr);
			}
		}
		return result;
	}
	
	boolean validateString(String numStr){
		int num = Integer.parseInt(numStr);
		if (!(num+"").equals(numStr)){
			return false;
		}
		if (num > 255 || num < 0){
			return false;
		}else{
			return true;
		}
	}
}
