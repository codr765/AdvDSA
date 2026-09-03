class Kadane {

    static int maxSumBrute(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    static int prefixSum(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];

        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int sum;

                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    static int kadane(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curr = 0;

        for (int i : nums) {
            curr += i;

            max = Math.max(max, curr);

            if (curr < 0) {
                curr = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 4, -7, 2, 5, -3, 2, 1, 5, -10, 3 };

        // System.out.println(maxSumBrute(nums));
        // System.out.println(prefixSum(nums));
        System.out.println(kadane(nums));
    }
}