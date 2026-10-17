import java.util.Stack;

public class LC456 {
    static boolean find132pattern(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int two = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < two) {
                return true;
            }

            while (!stk.isEmpty() && stk.peek() < nums[i]) {
                two = stk.pop();
            }

            stk.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        System.out.println(find132pattern(nums));
    }
}
