import java.util.Arrays;

public class ValidTriangles {

    static int triangleNumber(int[] nums) {
        int count = 0;

        Arrays.sort(nums);

        int right = nums.length - 1;

        while (right >= 2) {
            int left = 0;
            int mid = right - 1;

            while (left < mid) {
                if (nums[left] + nums[mid] > nums[right]) {
                    count += mid - left;
                    mid--;
                } else {
                    left++;
                }
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
