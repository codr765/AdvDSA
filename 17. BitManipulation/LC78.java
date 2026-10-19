import java.util.ArrayList;
import java.util.List;

public class LC78 {
    static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        int total = 1 << nums.length;

        for (int mask = 0; mask < total; mask++) {

            List<Integer> curr = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                if ((mask & (1 << i)) != 0) {
                    curr.add(nums[i]);
                }
            }

            ans.add(curr);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        System.out.println(subsets(nums));
    }
}
