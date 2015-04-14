import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NQueens {

    public void solution() {
        System.out.println(solveNQueens(4));
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> results = new ArrayList<String[]>();
        Info baseInfo = new Info(n);
        Stack<Info> infoStack = new Stack<Info>();
        infoStack.push(baseInfo);
        while(!infoStack.isEmpty()) {
            Info info = infoStack.pop();
            int row = info.chessNum;
            if (row >= n) {
                results.add(info.current);
                continue;
            }
            for (int col = 0; col < n; col++) {
                int leftSlash = n-1+row-col;
                int rightSlash = row + col;
                if (info.colUsed[col] == 0 &&
                        info.leftSlashUsed[leftSlash] == 0 &&
                        info.rightSlashUsed[rightSlash] == 0) {
                    Info newInfo = new Info(info);
                    newInfo.chessNum++;
                    newInfo.colUsed[col] = 1;
                    newInfo.leftSlashUsed[leftSlash] = 1;
                    newInfo.rightSlashUsed[rightSlash] = 1;
                    StringBuffer stringBuffer = new StringBuffer(info.current[row]);
                    stringBuffer.setCharAt(col, 'Q');
                    newInfo.current[row] = stringBuffer.toString();
                    infoStack.push(newInfo);
                }
            }
        }
        return results;
    }

    public class Info {
        public int chessNum;
        public int[] colUsed;
        public int[] leftSlashUsed;
        public int[] rightSlashUsed;
        public String[] current;

        public Info(int n) {
            chessNum = 0;
            colUsed = new int[n];
            leftSlashUsed = new int[2*n-1];
            rightSlashUsed = new int[2*n-1];
            current = new String[n];
            String emptyRow = "";
            for (int i = 0; i < current.length; i++) {
                emptyRow += ".";
            }
            for (int i = 0; i < current.length; i++) {
                current[i] = new String(emptyRow);
            }
        }

        public Info(Info info) {
            chessNum = info.chessNum;
            colUsed = info.colUsed.clone();
            leftSlashUsed = info.leftSlashUsed.clone();
            rightSlashUsed = info.rightSlashUsed.clone();
            current = new String[info.current.length];
            for (int i = 0; i < current.length; i++) {
                current[i] = new String(info.current[i]);
            }
        }
    }
}
