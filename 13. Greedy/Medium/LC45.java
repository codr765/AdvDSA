public class LC45 {
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == end) {
                jumps++;
                end = maxReach;
            }
        }

        return jumps;
    }
}