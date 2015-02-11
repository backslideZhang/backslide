import java.util.ArrayList;
import java.util.List;



public class RemoveDuplicatesFromSortedListII {
	
	public void solution(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		printList(deleteDuplicates(head));
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null){
			return head;
		}
		ListNode curNode = head;
		List<Integer> deleteList = new ArrayList<Integer>();
		while(curNode != null){
			if (curNode.next != null){
				if (curNode.val == curNode.next.val){
					if (!deleteList.contains(curNode.val)){
						deleteList.add(curNode.val);
					}
					curNode.next = curNode.next.next;
				}else{
					curNode = curNode.next;
				}
			}else{
				curNode = null;
			}
		}
		ListNode preNode = head;
		if (head != null){
			curNode = head.next;
		}else{
			curNode = null;
		}
		while(curNode != null){
			if (deleteList.contains(curNode.val)){
				preNode.next = curNode.next;
				curNode = preNode.next;
			}else{
				preNode = curNode;
				curNode = preNode.next;
			}
		}
		if (deleteList.contains(head.val)){
			head = head.next;
		}
		return head;
    }

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}
	
	private void printList(ListNode head) {
		if (head == null){
			System.out.println("NULL");
			return;
		}
		System.out.print(head.val+"");
		System.out.print("->");
		printList(head.next);
	}
}
