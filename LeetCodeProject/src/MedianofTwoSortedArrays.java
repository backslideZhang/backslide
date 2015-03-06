public class MedianofTwoSortedArrays {

    public void solution() {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2,3}));
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        int totalLength = A.length + B.length;
        int PosA = 0;
        int PosB = 0;
        double num1 = 0;
        double num2 = 0;
        for (int i = 0; i <= totalLength / 2; i++) {
            num2 = num1;
            if (PosA >= A.length) {
                num1 = B[PosB];
                PosB++;
                continue;
            }
            if (PosB >= B.length) {
                num1 = A[PosA];
                PosA++;
                continue;
            }
            if (A[PosA] > B[PosB]) {
                num1 = B[PosB];
                PosB++;
            } else {
                num1 = A[PosA];
                PosA++;
            }
        }
        if (totalLength % 2 == 0) {
            return (num1 + num2) / 2.0;
        } else {
            return num1;
        }
    }
}
