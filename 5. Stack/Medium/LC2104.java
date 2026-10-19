import java.util.Stack;

public class LC2104 {
    static long subArrayMaxSum(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                stk.pop();
            }

            maxLeft[i] = stk.isEmpty() ? i + 1 : i - stk.peek();

            stk.push(i);
        }

        stk.clear();

        for (int i = nums.length - 1; i > -1; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] <= nums[i]) {
                stk.pop();
            }

            maxRight[i] = stk.isEmpty() ? nums.length - i : stk.peek() - i;

            stk.push(i);
        }

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i] * maxLeft[i] * maxRight[i];
        }

        return sum;
    }

    static long subArrayMinSum(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;

        int[] minLeft = new int[n];
        int[] minRight = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }

            minLeft[i] = stk.isEmpty() ? i + 1 : i - stk.peek();

            stk.push(i);
        }

        stk.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                stk.pop();
            }

            minRight[i] = stk.isEmpty() ? n - i : stk.peek() - i;

            stk.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * minLeft[i] * minRight[i];
        }

        return sum;
    }

    static long subArrayRanges(int[] nums) {
        return subArrayMaxSum(nums) - subArrayMinSum(nums);
    }

    public static void main(String[] args) {
        System.out.println(subArrayMaxSum(new int[] { 4, -2, 4, 5, 3, 1 }));
    }
}