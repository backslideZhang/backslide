

public class SearchInRotatedSortedArray {
	public void solution(){
		System.out.println(search(new int[]{4,5,6,7,1,2,3}, 7));
	}
	
	public int search(int[] A, int target) {
		if (A[0] == target){
			return 0;
		}
		return binarySearch(A, 0, A.length-1, target);
    }

	private int binarySearch(int[] a, int l, int r, int target) {
		if (r-l <= 1){
			if (a[r] == target){
				return r;
			}else{
				return -1;
			}
		}
		int mid = (l + r) / 2;
		if (a[l] < a[r]){
			if (a[l] < target && a[mid] >= target){
				return binarySearch(a, l, mid, target);
			}
			if (a[mid] < target && a[r] >= target){
				return binarySearch(a, mid, r, target);
			}
			return -1;
		}else{
			return Math.max(binarySearch(a, l, mid, target), binarySearch(a, mid, r, target));
		}
	}
}
