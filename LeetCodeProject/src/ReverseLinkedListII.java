import java.util.Scanner;


public class ReverseLinkedListII {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		ListNode head = null;
		ListNode pre = null;
		while(scan.hasNextInt()){
			if (head == null){
				head = new ListNode(scan.nextInt());
				pre = head;
			}else{
				pre.next = new ListNode(scan.nextInt());
				pre = pre.next;
			}
		}
		pre.next = null;
		System.out.print("before:	");
		printList(head);
		head = reverseBetween(head, 1, 5);
		System.out.print("after:	");
		printList(head);
		scan.close();
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode begin = head;
		ListNode end = head;
		ListNode pre = head;
		int origin_n = n;
		int origin_m = m;
		while(true){
			if (--m > 0){
				pre = begin;
				begin = pre.next;
			}
			if (--n > 0){
				end = end.next;
			}else{
				break;
			}
		}
		if (begin.equals(end)){
			return head;
		}
		if (begin.equals(head)){
			head = head.next;
			begin.next = end.next;
			end.next = begin;
			return reverseBetween(head, origin_m, origin_n-1);
		}
		pre.next = begin.next;
		begin.next = end.next;
		end.next = begin;
		return reverseBetween(head, origin_m, origin_n-1);
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


	public class ListNode {
		public int val;
		public ListNode next;
		
		public ListNode(int x) {
			val = x;
		 	next = null;
		}
	}
}
