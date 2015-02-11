public class SameTree {

    public void solution() {
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        System.out.println(isSameTree(t1, t2));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null) {
                return true;
            } else {
                return false;
            }
        } else if (q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {val = x;}
    }
}
