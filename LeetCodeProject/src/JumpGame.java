import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {

    public void solution() {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public boolean canJump(int[] A) {
        Queue<Integer> positions = new LinkedList<Integer>();
        positions.add(0);
        while (!positions.isEmpty()) {
            int curPos = positions.poll();
            for (int i = A[curPos]; i > 0; i--) {
                int nextPos = i + curPos;
                if (nextPos >= A.length) {
                    return true;
                }
                if (!positions.contains(nextPos)) {
                    positions.add(nextPos);
                }
            }
        }
        return false;
    }
}
