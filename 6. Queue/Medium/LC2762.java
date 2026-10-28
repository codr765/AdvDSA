import java.util.ArrayDeque;
import java.util.Deque;

public class LC2762 {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int left = 0;
        long ans = 0;

        for (int right = 0; right < nums.length; right++) {

            while (!max.isEmpty() && max.peekLast() < nums[right]) {
                max.pollLast();
            }

            while (!min.isEmpty() && min.peekLast() > nums[right]) {
                min.pollLast();
            }

            max.offerLast(nums[right]);
            min.offerLast(nums[right]);

            while (max.peekFirst() - min.peekFirst() > 2) {

                if (max.peekFirst() == nums[left]) {
                    max.pollFirst();
                }

                if (min.peekFirst() == nums[left]) {
                    min.pollFirst();
                }

                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
