public class LC4 {
    static double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int k = 0; k <= (n + m) / 2; k++) {
            prev = curr;

            if (i < n && (j >= m || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        if ((n + m) % 2 == 0) {
            return (prev + curr) / 2.0;
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };

        System.out.println(findMedianSortedArraysBrute(nums1, nums2));
    }
}
