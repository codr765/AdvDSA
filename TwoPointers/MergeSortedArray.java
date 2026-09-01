import java.util.Arrays;

public class MergeSortedArray {
    static void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int p1 = 0;
        int p2 = 0;

        int index = 0;

        while (p1 < m && p2 < n) {
            if (nums2[p2] < nums1[p1]) {
                nums[index++] = nums2[p2++];
            }
            else {
                nums[index++] = nums1[p1++];
            }
        }

        while (p1 < m) {
            nums[index++] = nums1[p1++];
        }

        while (p2 < n) {
            nums[index++] = nums2[p2++];
        }

        System.arraycopy(nums, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        mergeBrute(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }
}
