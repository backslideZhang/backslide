public class SpiralMatrixII {

    public void solution() {
        print2DMatrix(generateMatrix(4));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n % 2 == 1) {
            matrix[n/2][n/2] = n*n;
        }
        int index = 0;
        int num = 1;
        for (int i = n - 1; i > 0; i -= 2) {
            for (int j = index; j < i + index; j++) {
                matrix[index][j] = num;
                num++;
            }
            for (int j = index; j < i + index; j++) {
                matrix[j][n - 1 - index] = num;
                num++;
            }
            for (int j = index; j < i + index; j++) {
                matrix[n - 1 - index][n - 1 - j] = num;
                num++;
            }
            for (int j = index; j < i + index; j++) {
                matrix[n - 1 - j][index] = num;
                num++;
            }
            index++;
        }
        return matrix;
    }

    public static void print2DMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                System.out.print(matrix[m][n] + " ");
            }
            System.out.println("");
        }
    }
}
