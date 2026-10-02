import java.util.*;

public class LC349 {

    static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> ans = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;

        for (int num : ans) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] result = intersection(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}