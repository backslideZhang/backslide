import java.util.Scanner;


public class CopyListWithRandomPointer {
	public void solution(){
		Scanner scan = new Scanner(System.in);
		RandomListNode head = null;
		RandomListNode pre = null;
		while(scan.hasNextInt()){
			if (head == null){
				head = new RandomListNode(scan.nextInt());
				pre = head;
			}else{
				pre.next = new RandomListNode(scan.nextInt());
				pre = pre.next;
			}
		}
		pre.next = null;
		pre = head;
		while(pre != null){
			if (pre.next == null){
				pre.random = head;
			}else{
				pre.random = pre.next.next;
			}
			pre = pre.next;
		}
		RandomListNode copyHead = copyRandomList(head);
		System.out.print("origin:");
		printList(head);
		System.out.print("copy  :");
		printList(copyHead);
		scan.close();
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null){
            return null;
        }
		RandomListNode point = head;
		while (point != null){
			RandomListNode newNode = new RandomListNode(point.label);
			newNode.next = point.next;
			point.next = newNode;
			point = newNode.next;
		}
		point = head;
		RandomListNode newHead = head.next;
		while(point != null){
			point.next.random = point.random!=null?point.random.next:null;
			point = point.next.next;
		}
		point = head;
		while(point != null){
			RandomListNode tmp = point.next.next;
			point.next.next = tmp!=null?tmp.next:null;
			point.next = tmp;
			point = point.next;
		}
		return newHead;
    }
	
	private void printList(RandomListNode head) {
		if (head == null){
			System.out.println("NULL");
			return;
		}
		System.out.print("id:"+head.hashCode()+" label:"+head.label+"(random:"+(head.random==null?"NULL":head.random.label)+")");
		System.out.print("->");
		printList(head.next);
	}
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	 
}
