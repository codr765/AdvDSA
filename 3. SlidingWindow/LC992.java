import java.util.HashMap;

public class LC992 {

    static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    static int atMostK(int[] nums, int k) {
        int count = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            hashMap.put(nums[right], hashMap.getOrDefault(nums[right], 0) + 1);

            while (hashMap.size() > k) {
                hashMap.put(nums[left], hashMap.get(nums[left]) - 1);

                if (hashMap.get(nums[left]) == 0) {
                    hashMap.remove(nums[left]);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
