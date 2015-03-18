public class ImplementstrStr {

    public void solution() {
        System.out.println(strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int j = 0;
        int pos = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j >= needle.length()) {
                    return pos;
                }
            } else {
                j = 0;
                i = pos;
                pos++;
            }
        }
        return -1;

        //TODO use KMP install
    }
}
