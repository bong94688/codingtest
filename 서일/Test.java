public class Test {

    //	NOTE:  복사된 돈 배열
    private static int[] money = new int[8];

    public static void save(int[] money2) {
        System.arraycopy(money2, 0, money, 0, money2.length); // money2의 값을 money에 복사
    }

    public static void withdraw(int[] account, int[][] result) {
        for (int i = 0; i < account.length; i++) {
            int amount = account[i];
            boolean isFullWithdrawPossible = true;
            int[] moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            for (int j = 0; j < moneyUnits.length; j++) {
            // NOTE:  재고가 있으면 바꾸고 없다면 그화폐로 못바꾼다. 최소니까 필요한만큼 numNotes에 저장
                int requiredNotes = amount / moneyUnits[j];
                int numNotes = Math.min(amount / moneyUnits[j], money[j]);
                if (numNotes < requiredNotes) { // 필요한 화폐 개수보다 재고가 적을 때
                    System.out.println("해당 권수가 부족합니다. " + moneyUnits[j] + " 필요한 재고는: " + requiredNotes + ", 현재 재고는: " + money[j] + "현재 인덱스는 " + i);
                }
            // NOTE: 그화폐에 얼마를 바꿀수 있는지 결과
                result[i][j] = numNotes;
            // NOTE: 바꾼 금액 감소
                amount -= numNotes * moneyUnits[j];
                money[j] -= numNotes; // 사용한 화폐 단위만큼 재고 감소
            }
        }
    }
}
