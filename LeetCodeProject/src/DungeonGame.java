public class DungeonGame {

    public void solution() {
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] minimumHP = new int[M][N];
        minimumHP[M-1][N-1] = 1 + (dungeon[M-1][N-1] > 0 ? 0 : -dungeon[M-1][N-1]);
        for (int m = M - 1; m >= 0; m--) {
            for (int n = N - 1; n >= 0; n--) {
                if (m == M - 1 && n == N - 1) {
                    continue;
                } else if (m == M - 1) {
                    minimumHP[m][n] = minimumHP[m][n + 1] - dungeon[m][n];
                } else if (n == N - 1) {
                    minimumHP[m][n] = minimumHP[m + 1][n] - dungeon[m][n];
                } else {
                    minimumHP[m][n] = Math.min(minimumHP[m + 1][n], minimumHP[m][n+1]) - dungeon[m][n];
                }
                if (minimumHP[m][n] <= 0) {
                    minimumHP[m][n] = 1;
                }
            }
        }
        return minimumHP[0][0];
    }
}
