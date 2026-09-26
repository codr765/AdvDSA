import java.util.Arrays;

public class ArrayFill {

    static void fill(int[] nums, int index) {
        if (index < 0) {
            return;
        }

        fill(nums, index - 1);
        nums[index] = index + 1;
    }

    static void minusTwo(int[] nums, int index) {
        if (index < 0) {
            return;
        }

        minusTwo(nums, index - 1);
        nums[index] -= 2;
    }

    static void backtrack(int[] nums, int idx, int val) {
        if (idx == nums.length) {
            System.out.println(Arrays.toString(nums));
            return;
        }

        nums[idx] = val;
        backtrack(nums, idx + 1, val + 1);
        nums[idx] -= 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[5];

        // fill(nums, nums.length - 1);
        // System.out.println(Arrays.toString(nums));

        // minusTwo(nums, nums.length - 1);
        // System.out.println(Arrays.toString(nums));

        backtrack(nums, 0, 1);
        System.out.println(Arrays.toString(nums));
    }
}
