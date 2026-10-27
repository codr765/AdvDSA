import java.util.ArrayDeque;
import java.util.Deque;

public class LC1438 {
    static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!max.isEmpty() && max.peekLast() < nums[right]) {
                max.pollLast();
            }

            while (!min.isEmpty() && min.peekLast() > nums[right]) {
                min.pollLast();
            }

            max.offerLast(nums[right]);
            min.offerLast(nums[right]);

            while (max.peekFirst() - min.peekFirst() > limit) {

                if (max.peekFirst() == nums[left]) {
                    max.pollFirst();
                }

                if (min.peekFirst() == nums[left]) {
                    min.pollFirst();
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[] { 8, 2, 4, 7 }, 4));
    }
}
