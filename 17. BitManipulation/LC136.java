public class LC136 {

    static int singleNumber(int[] nums) {
        int val = 0;

        for (int i : nums) {
            val = val ^ i;
        }

        return val;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 6, 6, 4 };
        System.out.println(singleNumber(nums));
    }
}
