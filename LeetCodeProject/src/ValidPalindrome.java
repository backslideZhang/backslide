public class ValidPalindrome {

    public void solution() {
        System.out.println(isPalindrome("1a1"));
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            char headCh = s.charAt(head);
            if ((headCh >= 'a' && headCh <= 'z') || (headCh >= 'A' && headCh <= 'Z') || Character.isDigit(headCh)) {
                char tailCh = s.charAt(tail);
                if (tailCh >= 'a' && tailCh <= 'z') {
                    if (tailCh != headCh) {
                        if (tailCh - 'a' + 'A' != headCh) {
                            return false;
                        }
                    }
                } else if (tailCh >= 'A' && tailCh <= 'Z') {
                    if (tailCh != headCh) {
                        if (tailCh - 'A' + 'a' != headCh) {
                            return false;
                        }
                    }
                } else if (Character.isDigit(tailCh)) {
                    if (tailCh != headCh) {
                        return false;
                    }
                } else {
                    tail--;
                    continue;
                }
            } else {
                head++;
                continue;
            }

            head++;
            tail--;
        }
        return true;
    }
}
