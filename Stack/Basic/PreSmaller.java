import java.util.Arrays;
import java.util.Stack;

public class PreSmaller {
    static int[] preSmaller(int[] nums) {
        int[] smaller = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        Arrays.fill(smaller, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }

            if (!stk.isEmpty()) {
                smaller[i] = nums[stk.peek()];
            }

            stk.push(i);
        }

        return smaller;

        // for (int i = nums.length - 1; i > -1; i--) {
        // while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
        // smaller[stk.pop()] = nums[i];
        // }

        // stk.push(i);
        // }

        // return smaller;
    }

    public static void main(String[] args) {

        int[] nums = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };

        System.out.println(Arrays.toString(preSmaller(nums)));
    }
}
