public class LC1493 {
    static int longestSubarray(int[] nums) {
        int mx = 0;

        int zeroes = 0;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroes++;
            }

            while (zeroes > 1) {
                if (nums[left] == 0) {
                    zeroes--;
                }

                left++;
            }

            mx = Math.max(mx, right - left);
        }

        return mx;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };

        System.out.println(longestSubarray(nums));
    }
}
