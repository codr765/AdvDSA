public class LC209 {

    static int minSubArrayLen(int target, int[] nums) {

        // int min = Integer.MAX_VALUE;

        // int[] prefix = new int[nums.length + 1];

        // for (int i = 1; i < prefix.length; i++) {
        // prefix[i] = prefix[i - 1] + nums[i - 1];
        // }

        // for (int i = 1; i < prefix.length; i++) {
        // int required = prefix[i] - target;

        // int start = 0;
        // int end = i - 1;
        // int curr = -1;

        // while (start <= end) {
        // int mid = (start + end) / 2;

        // if (prefix[mid] <= required) {
        // curr = mid;
        // start = mid + 1;
        // } else {
        // end = mid - 1;
        // }
        // }
        // if (curr != -1) {
        // min = Math.min(min, i - curr);
        // }

        // }
        // return min == Integer.MAX_VALUE ? 0 : min;

        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                min = Math.min(min, right - left + 1);

                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));
    }
}
