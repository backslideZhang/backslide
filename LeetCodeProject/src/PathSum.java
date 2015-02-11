
public class PathSum {
	public void solution(){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		System.out.println(hasPathSum(root, 25));
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null){
			return false;
		}
		if (isLeaf(root)){
			if (root.val == sum){
				return true;
			}else{
				return false;
			}
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	
	public boolean isLeaf(TreeNode node){
		return node.left == null && node.right == null;
	}
	
	public class TreeNode {
		int val;
		TreeNode left = null;
		TreeNode right = null;
		TreeNode(int x) { val = x; }
	}
}
