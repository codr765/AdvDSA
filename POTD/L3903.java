public class L3903 {

    static int firstStableIndex(int[] nums, int k) {

        int[] min = new int[nums.length];

        min[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);

            if (max - min[i] <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 0, 1, 4 };

        System.out.println(firstStableIndex(nums, 3));
    }
}