public class StringtoInteger {

    public void solution() {
        System.out.println(atoi("2147483648"));
    }

    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int sig = 1;
        int startPos = 0;
        if (str.charAt(0) == '-') {
            sig = -1;
            startPos++;
        } else if (str.charAt(0) == '+') {
            startPos++;
        }
        int result = 0;
        for (;startPos < str.length(); startPos++) {
            int nextVal = str.charAt(startPos) - '0';
            if (nextVal > 9 || nextVal < 0) {
                break;
            }
            if (result > Integer.MAX_VALUE / 10) {
                if (sig > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (result == Integer.MAX_VALUE / 10) {
                if (startPos == str.length() - 1) {
                    if (sig > 0) {
                        if (nextVal >= 7) {
                            return Integer.MAX_VALUE;
                        }
                    } else {
                        if (nextVal >= 8) {
                            return Integer.MIN_VALUE;
                        }
                    }
                } else {
                    return 0;
                }
            }
            result = result * 10 + nextVal;
        }
        return sig * result;
    }
}
