
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if (head == null){
    		return head;
    	}
    	ListNode[] nodeArray = new ListNode[k];
    	int count = 0;
    	for (; count < k; count++){
    		if (count == 0){
    			nodeArray[count] = head;
    		}else{
    			nodeArray[count] = nodeArray[count-1].next;
    			if (nodeArray[count] == null){
    				break;
    			}
    		}
    	}
    	if (count >= k){
    		ListNode tmp = nodeArray[k-1].next;
    		for (int i = 1; i < k; i++){
    			nodeArray[i].next = nodeArray[i-1];
    		}
    		nodeArray[0].next = reverseKGroup(tmp, k);
    		head = nodeArray[k-1];
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
