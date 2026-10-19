import java.util.Arrays;
import java.util.Stack;

public class LC907 {
    static int[] prevSmaller(int[] nums) {
        int[] smaller = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        Arrays.fill(smaller, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }

            smaller[i] = stk.isEmpty() ? i + 1 : i - stk.peek();

            stk.push(i);
        }

        return smaller;
    }

    static int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] smaller = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }

            smaller[i] = stk.isEmpty() ? n - i : stk.peek() - i;

            stk.push(i);
        }

        return smaller;
    }

    static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;

        int[] left = prevSmaller(arr);
        int[] right = nextSmaller(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };

        System.out.println(sumSubarrayMins(arr));
    }
}
