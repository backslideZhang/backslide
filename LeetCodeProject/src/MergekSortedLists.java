import java.util.List;

public class MergekSortedLists {

    public void solution() {}

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = null;
        ListNode cur = null;
        ListNodeHeap heap = new ListNodeHeap(lists.size());
        for (ListNode list : lists) {
            if (list != null) {
                heap.push(list);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        head = heap.pop();
        cur = head;
        if (head.next != null) {
            heap.push(head.next);
        }
        while (!heap.isEmpty()) {
            ListNode temp = heap.pop();
            cur.next = temp;
            cur = temp;
            if (temp.next != null) {
                heap.push(temp.next);
            }
        }
        return head;
    }

    public class ListNodeHeap {
        private ListNode[] heap;
        private int tail;
        private int maxSize;

        public ListNodeHeap(int maxSize) {
            this.maxSize = maxSize;
            tail = 0;
            heap = new ListNode[maxSize];
        }

        public void push(ListNode element) {
            if (tail < maxSize) {
                heap[tail] = element;
                ShiftUp(tail);
                tail++;
            }
        }

        public void ShiftUp(int pos) {
            ListNode temp = heap[pos];
            while(pos > 0 && heap[(pos - 1) / 2].val > temp.val) {
                int parent = (pos - 1) / 2;
                heap[pos] = heap[parent];
                pos = parent;
            }
            heap[pos] = temp;
        }

        public ListNode pop() {
            if (tail > 0) {
                ListNode result = heap[0];
                tail--;
                heap[0] = heap[tail];
                ShiftDown(0);
                return result;
            } else {
                return null;
            }
        }

        public void ShiftDown(int pos) {
            ListNode temp = heap[pos];
            while (pos * 2 + 1 < tail) {
                int minChild = pos * 2 + 1;
                if (minChild + 1 < tail && heap[minChild].val > heap[minChild + 1].val) {
                    minChild++;
                }
                if (temp.val > heap[minChild].val) {
                    heap[pos] = heap[minChild];
                    pos = minChild;
                } else {
                    break;
                }
            }
            heap[pos] = temp;
        }

        public boolean isEmpty() {
            return tail == 0;
        }
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
