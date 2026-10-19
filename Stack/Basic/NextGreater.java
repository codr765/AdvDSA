import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    static int[] nextGreater(int[] nums) {
        int[] greater = new int[nums.length];
        Stack<Integer> stk = new Stack<>();

        Arrays.fill(greater, -1);

        for (int i = 0; i < nums.length; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] < nums[i]) {
                greater[stk.pop()] = nums[i];
            }

            stk.push(i);
        }

        return greater;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };

        System.out.println(Arrays.toString(nextGreater(nums)));
    }
}
