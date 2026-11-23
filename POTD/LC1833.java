public class LC1833 {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];

        for (int cost : costs) {
            freq[cost]++;
        }

        int ct = 0;

        for (int i = 1; i <= 100000; i++) {
            while (freq[i] > 0 && coins >= i) {
                coins -= i;
                ct++;
                freq[i]--;
            }

            if (coins < i) {
                break;
            }
        }

        return ct;
    }
}
