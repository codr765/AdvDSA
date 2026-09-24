public class LC3550 {

    static int sumOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }

        return sum;
    }

    static int smallestIndex(int[] nums) {
        int min = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sumOfDigits(nums[i]) == i) {
                min = i;
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 10, 11 };

        System.out.println(smallestIndex(nums));
    }
}