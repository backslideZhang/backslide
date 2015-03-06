public class PalindromeNumber {

    public void solution() {
        System.out.println(isPalindrome(1000021));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int length = (int) Math.floor(Math.log10(x));
        int divNum = (int) Math.pow(10,length);
        while (divNum > 0) {
            if (x % 10 == x / divNum) {
                x = x % divNum;
                x = x / 10;
                divNum = divNum / 100;
            } else {
                return false;
            }
        }
        return true;
    }
}
