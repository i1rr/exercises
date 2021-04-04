package arrays;

public class SumWithStopEl {
    public static int count(int[] data, int el) {
        int sum = 0;
        for (int rr : data) {
            if (rr == el) {
                break;
            }
            sum += rr;
        }
        return sum % 2 == 0 ? sum : 0;
    }
}