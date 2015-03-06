public class ReverseInteger {

    public void solution() {
        System.out.println(reverse(1534236469));
    }

    public int reverse(int x) {
        int result = 0;
        int sig = x < 0?-1:1;
        x = x * sig;
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return sig * result;
    }
}
