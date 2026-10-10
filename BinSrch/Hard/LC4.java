public class LC4 {
    static double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int iter = total / 2;

        int i = 0;
        int idx1 = 0;
        int idx2 = 0;
        int prev = 0;
        int curr = 0;

        while (i <= iter) {
            prev = curr;

            if (idx1 < nums1.length && (idx2 >= nums2.length || nums1[idx1] <= nums2[idx2])) {
                curr = nums1[idx1++];
            } else {
                curr = nums2[idx2++];
            }

            i++;
        }

        if (total % 2 == 1) {
            return curr;
        }

        return ((double) prev + curr) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };

        System.out.println(findMedianSortedArraysBrute(nums1, nums2));
    }
}
