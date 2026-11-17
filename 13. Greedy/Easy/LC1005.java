import java.util.Arrays;

public class LC1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        if (k % 2 != 0) {
            sum -= 2 * min;
        }

        return sum;
    }
}