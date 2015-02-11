
public class SwapNodesInPairs {
	public void solution(){
	}
	
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode node1 = head;
		ListNode node2 = head.next;
		node1.next = swapPairs(node2.next);
		node2.next = node1;
		return node2;
    }

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
