import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {

    public void solution() {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }
    public int jump(int[] A) {
        if (A.length < 2) {
            return 0;
        }
        Queue<JumpInfo> queue = new LinkedList<JumpInfo>();
        int[] used = new int[A.length];
        used[0] = -1;
        queue.add(new JumpInfo(0, 0));
        while(!queue.isEmpty()) {
            JumpInfo curInfo = queue.poll();
            for (int i = A[curInfo.curPos]; i > 0; i--) {
                int nextPos = curInfo.curPos + i;
                if (nextPos >= A.length-1) {
                    return curInfo.curLength+1;
                } else if (used[nextPos] >= 0) {
                    used[nextPos] = -1;
                    queue.add(new JumpInfo(nextPos, curInfo.curLength+1));
                }
            }
        }
        return 0;
    }

    public class JumpInfo {
        public int curPos;
        public int curLength;
        public JumpInfo(int curPos, int curLength) {
            this.curPos = curPos;
            this.curLength = curLength;
        }
    }
}
