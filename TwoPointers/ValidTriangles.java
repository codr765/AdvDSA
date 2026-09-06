import java.util.Arrays;

public class ValidTriangles {

    static int triangleNumber(int[] nums) {
        int count = 0;

        Arrays.sort(nums);

        int right = nums.length - 1;

        while (right >= 2) {
            int left = 0;

            while (left < right - 1) {
                int mid = left + 1;

                while (mid < right && nums[left] + nums[mid] <= nums[right]) {
                    mid++;
                }

                count += right - mid;
                left++;
            }

            right--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 4 };

        System.out.println(triangleNumber(nums));
    }
}