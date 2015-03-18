public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int length = A.length;
        int newPos = 1;
        int oldPos = 1;
        for (;oldPos < A.length; oldPos++) {
            if (A[oldPos] != A[oldPos - 1]) {
                newPos++;
            } else {
                length--;
            }
            A[newPos] = A[oldPos];
        }
        return length;
    }
}
