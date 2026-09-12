import java.util.Arrays;
import java.util.HashMap;

public class LC594 {

    static int findLHS(int[] nums) {

        // Arrays.sort(nums);

        // int count = 0;
        // int left = 0;

        // for (int right = 0; right < nums.length; right++) {
        //     while (nums[right] - nums[left] > 1) {
        //         left++;
        //     }
        //     if (nums[right] - nums[left] == 1) {
        //         count = Math.max(count, right - left + 1);
        //     }
        // }

        // return count;
        

        // HashMap<Integer, Integer> map = new HashMap<>();

        // for (int num : nums) {
        // map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // int ans = 0;

        // for (int num : map.keySet()) {
        // if (map.containsKey(num + 1)) {
        // ans = Math.max(ans, map.get(num) + map.get(num + 1));
        // }
        // }

        // return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };

        System.out.println(findLHS(nums));

    }
}