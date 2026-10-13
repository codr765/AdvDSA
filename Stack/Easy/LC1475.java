import java.util.Arrays;
import java.util.Stack;

public class LC1475 {
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = prices.clone();

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && prices[stk.peek()] >= prices[i]) {
                int idx = stk.pop();
                ans[idx] = prices[idx] - prices[i];
            }

            stk.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] prices = { 8, 4, 6, 2, 3 };

        System.out.println(Arrays.toString(finalPrices(prices)));
    }
}