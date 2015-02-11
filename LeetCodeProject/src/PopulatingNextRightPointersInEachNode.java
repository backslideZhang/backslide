import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		int deep = 0;
		TreeLinkNode node = root;
		while(node != null){
			node = node.left;
			deep++;
		}
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.offer(root);
		int curLevel = 0;
		while(curLevel < deep){
			int nodeNum = (int) Math.pow(2, curLevel);
			TreeLinkNode preNode = null;
			for (int i = 0; i < nodeNum; i++){
				TreeLinkNode curNode = queue.poll();
				if (curNode == null){
					break;
				}
				if (curNode.left != null && curNode.right != null){
					queue.offer(curNode.left);
					queue.offer(curNode.right);
				}
				curNode.next = null;
				if (preNode != null){
					preNode.next = curNode;
				}
				preNode = curNode;
			}
			curLevel++;
		}
    }

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}
