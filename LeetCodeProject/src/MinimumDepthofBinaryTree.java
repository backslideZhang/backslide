import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree {
    public void solution() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(minDepth(root));

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> currentNodes = new LinkedList<TreeNode>();
        Queue<TreeNode> nextNodes = new LinkedList<TreeNode>();
        currentNodes.add(root);
        int depth = 1;
        while (true) {
            if (!currentNodes.isEmpty()) {
                TreeNode node = currentNodes.poll();
                if (node.left == null && node.right == null) {
                    break;
                }
                if (node.left != null) {
                    nextNodes.add(node.left);
                }
                if (node.right != null) {
                    nextNodes.add(node.right);
                }
            } else {
                if (!nextNodes.isEmpty()) {
                    currentNodes.addAll(nextNodes);
                    nextNodes.clear();
                    depth++;
                } else {
                    break;
                }
            }
        }
        return depth;
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
