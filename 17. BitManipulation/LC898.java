import java.util.HashSet;
import java.util.Set;

public class LC898 {
    static int subarrayBitwiseORs(int[] arr) {

        Set<Integer> ans = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {

            Set<Integer> curr = new HashSet<>();

            curr.add(num);

            for (int x : prev) {
                curr.add(x | num);
            }

            ans.addAll(curr);

            prev = curr;
        }

        return ans.size();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4 };

        System.out.println(subarrayBitwiseORs(nums));
    }
}
