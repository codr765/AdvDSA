public class LC1004 {
    static int longestOnes(int[] nums, int k) {
        int mx = 0;

        int zeroes = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroes++;
            }

            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }

            mx = Math.max(mx, right - left + 1);
        }

        return mx;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };

        System.out.println(longestOnes(nums, 2));
    }
}
