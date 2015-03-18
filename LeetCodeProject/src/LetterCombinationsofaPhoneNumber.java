import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationsofaPhoneNumber {

    public void solution() {
        System.out.println(letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Queue<String> queueOld = new ArrayDeque<String>();
        Queue<String> queueNew = new ArrayDeque<String>();
        String pre = "";
        char num = digits.charAt(0);
        switch (num) {
            case '2':
                queueNew.add(pre + "a");
                queueNew.add(pre + "b");
                queueNew.add(pre + "c");
                break;
            case '3':
                queueNew.add(pre + "d");
                queueNew.add(pre + "e");
                queueNew.add(pre + "f");
                break;
            case '4':
                queueNew.add(pre + "g");
                queueNew.add(pre + "h");
                queueNew.add(pre + "i");
                break;
            case '5':
                queueNew.add(pre + "j");
                queueNew.add(pre + "k");
                queueNew.add(pre + "l");
                break;
            case '6':
                queueNew.add(pre + "m");
                queueNew.add(pre + "n");
                queueNew.add(pre + "o");
                break;
            case '7':
                queueNew.add(pre + "p");
                queueNew.add(pre + "q");
                queueNew.add(pre + "r");
                queueNew.add(pre + "s");
                break;
            case '8':
                queueNew.add(pre + "t");
                queueNew.add(pre + "u");
                queueNew.add(pre + "v");
                break;
            case '9':
                queueNew.add(pre + "w");
                queueNew.add(pre + "x");
                queueNew.add(pre + "y");
                queueNew.add(pre + "z");
                break;
            default:
                break;
        }
        digits = digits.substring(1);
        queueOld.addAll(queueNew);
        queueNew.clear();
        while(digits.length() > 0) {
            num = digits.charAt(0);
            while (queueOld.size() > 0) {
                pre = queueOld.poll();
                switch (num) {
                    case '2':
                        queueNew.add(pre + "a");
                        queueNew.add(pre + "b");
                        queueNew.add(pre + "c");
                        break;
                    case '3':
                        queueNew.add(pre + "d");
                        queueNew.add(pre + "e");
                        queueNew.add(pre + "f");
                        break;
                    case '4':
                        queueNew.add(pre + "g");
                        queueNew.add(pre + "h");
                        queueNew.add(pre + "i");
                        break;
                    case '5':
                        queueNew.add(pre + "j");
                        queueNew.add(pre + "k");
                        queueNew.add(pre + "l");
                        break;
                    case '6':
                        queueNew.add(pre + "m");
                        queueNew.add(pre + "n");
                        queueNew.add(pre + "o");
                        break;
                    case '7':
                        queueNew.add(pre + "p");
                        queueNew.add(pre + "q");
                        queueNew.add(pre + "r");
                        queueNew.add(pre + "s");
                        break;
                    case '8':
                        queueNew.add(pre + "t");
                        queueNew.add(pre + "u");
                        queueNew.add(pre + "v");
                        break;
                    case '9':
                        queueNew.add(pre + "w");
                        queueNew.add(pre + "x");
                        queueNew.add(pre + "y");
                        queueNew.add(pre + "z");
                        break;
                    default:
                        break;
                }
            }
            digits = digits.substring(1);
            queueOld.addAll(queueNew);
            queueNew.clear();
        }
        result.addAll(queueOld);
        return result;
    }
}
