import java.util.Stack;

public class LC1856 {
    static int maxSumMinProduct(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }

            left[i] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(i);
        }

        stk.clear();

        for (int i = nums.length - 1; i > -1; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }

            right[i] = stk.isEmpty() ? nums.length : stk.peek();

            stk.push(i);
        }

        long max = 0;
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int L = left[i] + 1;
            int R = right[i] - 1;

            long subarraySum = prefix[R + 1] - prefix[L];

            long product = subarraySum * nums[i];

            max = Math.max(max, product);
        }

        return (int) (max % 1000000007);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 2 };

        System.out.println(maxSumMinProduct(nums)); // 14
    }
}
