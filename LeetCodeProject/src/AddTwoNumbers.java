public class AddTwoNumbers {
    public void solution(){
        addTwoNumbers(new ListNode(5), new ListNode(5));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int base = (l1.val + l2.val) % 10;
        ListNode head = new ListNode(base);
        int carrier = (l1.val + l2.val) / 10;
        ListNode l = head;
        int a = 0;
        int b = 0;
        while((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || carrier != 0) {
            a = (l1 != null &&l1.next != null)?l1.next.val:0;
            b = (l2 != null &&l2.next != null)?l2.next.val:0;
            base = (a + b + carrier) % 10;
            l.next = new ListNode(base);
            carrier = (a + b + carrier) / 10;
            l = l.next;
            l1 = l1 != null?l1.next:null;
            l2 = l2 != null?l2.next:null;
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
}
