public class QuickSort {

    public void solution() {
        int[] array = new int[]{3,3,3,3,2,2,2,2,1,1,1,1,0,0,0,0};
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int l, int r) {
        if (l == r) {
            return;
        }
        if (r - l == 1) {
            if (array[l] > array[r]) {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
            return;
        }
        int key = l;
        int ll = l;
        int rr = r;
        int keyValue = array[key];
        while (ll < rr) {
            while (ll < rr && array[rr] > keyValue) {
                rr--;
            }
            if (ll < rr) {
                swapArray(array, key, rr);
                key = rr;
            }
            while(ll < rr && array[ll] <= keyValue) {
                ll++;
            }
            if (ll < rr) {
                swapArray(array, ll, key);
                key = ll;
            }
        }
        if (key > l) {
            sort(array, l, key - 1);
        }
        if (key < r) {
            sort(array, key + 1, r);
        }
    }

    private void swapArray(int[] array, int pos1, int pos2) {
        int tmp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = tmp;
    }
}
