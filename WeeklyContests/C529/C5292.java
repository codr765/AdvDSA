public class C5292 {
    static long minCost(int[] nums) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        int i = 0;

        while (i < n) {
            int j = i;

            while (j < n && nums[j] == nums[i]) {
                j++;
            }

            int len = j - i;

            if (i < n - 1 && j > 1) {
                long cost = (long) nums[i] * (n - len);
                ans = Math.min(ans, cost);
            }

            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 6, 3, 3 }; // 3,4,4,5,4,4,3 // 3, 3, 3, 6, 3, 3

        System.out.println(minCost(nums));
    }
}