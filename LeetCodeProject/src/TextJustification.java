import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TextJustification {
	
	public void solution(){
		System.out.println(fullJustify(new String[]{""},0));
	}
	
	public List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
		if (words.length <= 0){
			return result;
		}
		List<String> tmp = new ArrayList<String>();
		Map<Integer, String> blankMap = new HashMap<Integer, String>();
		String blank = "";
		for (int i = 0; i <= L; i++){
			blankMap.put(i, new String(blank));
			blank += " ";
		}
		int remained = L;
		tmp.clear();
		for (int i = 0; i < words.length; i++){
			if (words[i].length() <= remained){
				tmp.add(words[i]);
				remained -= (words[i].length()+1);
			}else{
				if (tmp.size() > 1){
					remained += tmp.size();
					int blankNum = tmp.size() - 1;
					int blankLengthMin = remained / blankNum;
					int remainedBlank = remained - blankLengthMin * blankNum;
					String resultTmp = "";
					for (int j = 0; j < blankNum; j++){
						if (j < remainedBlank){
							resultTmp += tmp.get(j)+blankMap.get(blankLengthMin+1);
						}else{
							resultTmp += tmp.get(j)+blankMap.get(blankLengthMin);
						}
					}
					result.add(resultTmp+tmp.get(blankNum));
				}else{
					result.add(tmp.get(0) + blankMap.get(remained+1));
				}
				tmp.clear();
				remained = L;
				i--;
			}
		}
		if (tmp.size() > 0){
			String resultTmp = "";
			for (int i = 0; i < tmp.size(); i++){
				resultTmp += tmp.get(i) + " ";
			}
			resultTmp = resultTmp.trim() + blankMap.get(L-resultTmp.trim().length());
			result.add(resultTmp);
		}
		return result;
    }
}
