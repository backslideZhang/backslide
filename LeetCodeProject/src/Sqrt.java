public class Sqrt {

    public void solution() {
        System.out.println(sqrt(2147395599));
    }

    public int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0;
        int r = x;
        while (r - l > 1) {
            int mid=(l+r)/2;
            if (mid>46340 || mid*mid>x) {
                r = mid;
            } else if (mid*mid<x) {
                l = mid;
            } else {
                return mid;
            }
        }
        return l;
    }
}
