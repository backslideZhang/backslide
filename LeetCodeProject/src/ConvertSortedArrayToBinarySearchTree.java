
public class ConvertSortedArrayToBinarySearchTree {
	public void solution(){
		sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
		TreeNode result = sortedArrayToBstWithBeginEnd(num, 0, num.length - 1);
		return result;
    }
	
	private TreeNode sortedArrayToBstWithBeginEnd(int[] num, int begin, int end) {
		if (end - begin < 0){
			return null;
		}
		int mid = (begin + end) / 2;
		TreeNode node = new TreeNode(num[mid]);
		if (end == begin){
			node.left = null;
			node.right = null;
		}else{
			node.left = sortedArrayToBstWithBeginEnd(num, begin, mid - 1);
			node.right = sortedArrayToBstWithBeginEnd(num, mid + 1, end);
		}
		return node;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
