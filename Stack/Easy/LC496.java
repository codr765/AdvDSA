import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496 {
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        for (int num : nums2) {

            while (!stk.isEmpty() && stk.peek() < num) {
                map.put(stk.pop(), num);
            }

            stk.push(num);
        }

        int idx = 0;

        for (int num : nums1) {
            ans[idx++] = map.getOrDefault(num, -1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
