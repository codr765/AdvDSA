public class LC137 {

    static int singleNumber(int[] nums) {

        int ans = 0;

        for (int bit = 0; bit < 32; bit++) {

            int count = 0;

            for (int num : nums) {

                if (((num >> bit) & 1) == 1) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                ans = ans | (1 << bit);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1, 0, 1, 99 };

        System.out.println(singleNumber(nums));
    }
}
