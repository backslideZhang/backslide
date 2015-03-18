public class MinHeapTest {
    public void solution() {
        MinHeap minHeap = new MinHeap(10);
        minHeap.push(17);
        minHeap.push(26);
        minHeap.push(19);
        minHeap.push(14);
        minHeap.push(20);
        minHeap.push(12);
        minHeap.push(22);
        minHeap.push(18);
        minHeap.push(15);
        minHeap.push(24);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.pop());
        }
    }

    public class MinHeap {
        private int[] heap;
        private int tail;
        private int maxSize;

        public MinHeap(int maxSize) {
            this.maxSize = maxSize;
            tail = 0;
            heap = new int[maxSize];
        }

        public void push(int element) {
            if (tail < maxSize) {
                heap[tail] = element;
                ShiftUp(tail);
                tail++;
            }
        }

        private void ShiftUp(int pos) {
            int temp = heap[pos];
            while(pos > 0 && heap[(pos - 1) / 2] > temp) {
                int parent = (pos - 1) / 2;
                heap[pos] = heap[parent];
                pos = parent;
            }
            heap[pos] = temp;
        }

        public int pop() {
            if (tail > 0) {
                int result = heap[0];
                tail--;
                heap[0] = heap[tail];
                ShiftDown(0);
                return result;
            }
            return -1;
        }

        private void ShiftDown(int pos) {
            int temp = heap[pos];
            while (pos * 2 + 1 < tail) {
                int minChild = pos * 2 + 1;
                if (minChild + 1 < tail && heap[minChild] > heap[minChild + 1]) {
                    minChild++;
                }
                if (temp > heap[minChild]) {
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
}
