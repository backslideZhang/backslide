import java.util.Scanner;

public class BaiduQuestion2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int caseNum = scan.nextInt();
        InputData[] cases = new InputData[caseNum];
        for (int i = 0; i < caseNum; i++) {
            cases[i] = new InputData();
            cases[i].canteenNum = scan.nextInt();
            cases[i].minConsume = scan.nextInt();
            cases[i].maxConsume = scan.nextInt();
            cases[i].canteenDatas = new CanteenData[cases[i].canteenNum];
            for (int j = 0; j < cases[i].canteenNum; j++) {
                cases[i].canteenDatas[j] = new CanteenData();
                cases[i].canteenDatas[j].foodNum = scan.nextInt();
                cases[i].canteenDatas[j].foods = new Food[cases[i].canteenDatas[j].foodNum];
                for (int k = 0; k < cases[i].canteenDatas[j].foodNum; k++) {
                    cases[i].canteenDatas[j].foods[k] = new Food();
                    cases[i].canteenDatas[j].foods[k].price = scan.nextInt();
                    cases[i].canteenDatas[j].foods[k].score = scan.nextInt();
                }
            }
        }
        for (int i = 0; i < caseNum; i++) {
            getMaxScore(cases[i]);
        }
    }

    private static void getMaxScore(InputData aCase) {

    }

    public static class InputData {
        int canteenNum;
        int minConsume;
        int maxConsume;
        CanteenData[] canteenDatas;
    }

    public static class CanteenData {
        int foodNum;
        Food[] foods;
    }

    public static class Food {
        int price;
        int score;
    }
}
