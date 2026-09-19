import java.util.Arrays;

public class LC260 {
    static int[] singleNumber(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int bit = xor & -xor;

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((num & bit) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };

        System.out.println(Arrays.toString(singleNumber(nums)));
    }
}
