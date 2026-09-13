public class Q2 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2 };

        int count = 0;

        int firstHalf = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        for (int i = 0; i < nums.length / 2; i++) {
            firstHalf += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (2 * firstHalf > total) {
                count++;
            }
            firstHalf = firstHalf - nums[i] + nums[(i + nums.length / 2) % nums.length];
        }

        System.out.println(count);
    }
}
