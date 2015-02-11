import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
	public void solution(){
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		connect(root);
	}
	
	public void connect(TreeLinkNode root) {
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int nextLevelNodeNum = 1;
		while(!queue.isEmpty()){
			int nodeNum = nextLevelNodeNum;
			nextLevelNodeNum = 0;
			TreeLinkNode preNode = null;
			for (int i = 0; i < nodeNum; i++){
				TreeLinkNode curNode = queue.poll();
				if (curNode == null){
					break;
				}
				if (curNode.left != null){
					queue.offer(curNode.left);
					nextLevelNodeNum++;
				}
				if(curNode.right != null){
					queue.offer(curNode.right);
					nextLevelNodeNum++;
				}
				curNode.next = null;
				if (preNode != null){
					preNode.next = curNode;
				}
				preNode = curNode;
			}
		}
    }

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}
