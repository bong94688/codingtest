public class Main {
    private static long SEED = 5; // will be changed

    private static int[] money = new int[8];
    private static int[] money2 = new int[8];
    private static int[] account = new int[1000];
    private static int[] account2 = new int[1000];
    private static int[][] result = new int[1000][8];


    private static int rand() {
        SEED = SEED * 25214903917L + 11L;

        return (int) ((SEED >> 16) & 0x7fff);
    }


    public static void main(String args[]) {
        int SCORE = 0;

//		NOTE: 여기서 100 번 돌면서 100개 테스트 하는거!.
        for (int repeat = 0; repeat < 100; repeat++) {
            for (int c = 0; c < 8; c++) {
//                NOTE: 돈 복사
                money2[c] = money[c] = rand() % 500;
            }

//            NOTE: Test에 돈 배열 복사
            Test.save(money2);

            for (int c = 0; c < 1000; c++) {
//                NOTE: 랜덤 돈
                account2[c] = account[c] = (rand() % 10000) * 10;
            }

//            NOTE: account2 의 돈 변경
            Test.withdraw(account2, result);

            for (int c = 0; c < 1000; c++) {
                if (account[c] != result[c][0] * 50000 + result[c][1] * 10000 + result[c][2] * 5000 + result[c][3] * 1000 + result[c][4] * 500 + result[c][5] * 100 + result[c][6] * 50 + result[c][7] * 10) {
                    SCORE += 1000;
                    continue;
                }

                for (int d = 0; d < 8; d++) {
                    money[d] -= Math.abs(result[c][d]);
                }
            }

            for (int c = 0; c < 8; c++) {
                if (money[c] < 0) {
                    SCORE += 100000000;
                }
            }
        }

        System.out.printf("SCORE: %d\n", SCORE);
    }


}
