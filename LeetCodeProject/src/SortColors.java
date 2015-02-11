
public class SortColors {
	public void solution(){
		sortColors(new int[]{1,2,0});
	}
	
	public void sortColors(int[] A) {
        int begin = 0;
        int end = A.length-1;
        int pos = 0;
        for (pos = 0;pos < end+1; pos++){
        	if (A[pos] == 0){
        		if (pos == begin){
        			continue;
        		}
        		int tmp = A[begin];
        		A[begin] = A[pos];
        		A[pos] = tmp;
        		begin++;
        		pos--;
        	}else if (A[pos] == 2){
        		if (pos == end){
        			continue;
        		}
        		int tmp = A[end];
        		A[end] = A[pos];
        		A[pos] = tmp;
        		end--;
        		pos--;
        	}
        }
    }
}
