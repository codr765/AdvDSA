import java.util.Arrays;
import java.util.Stack;

public class LC503 {
    static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        Arrays.fill(ans, -1);
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (!stk.isEmpty() && stk.peek() <= nums[idx]) {
                stk.pop();
            }

            if (i < n && !stk.isEmpty()) {
                ans[idx] = stk.peek();
            }

            stk.push(nums[idx]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 };
        // {2, 3, 4, -1, 4}

        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
