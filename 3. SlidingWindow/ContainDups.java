import java.util.HashMap;
// import java.util.HashSet;

class ContainDups {

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        // for (int i = 1; i <= k; i++) {
        // for (int j = 0; j < nums.length - i; j++) {
        // if (nums[j] == nums[j + i]) {
        // return true;
        // }
        // }
        // }

        // return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;

        // HashSet<Integer> set = new HashSet<>();

        // for (int i = 0; i < nums.length; i++) {

        //     if (set.contains(nums[i])) {
        //         return true;
        //     }

        //     set.add(nums[i]);

        //     if (set.size() > k) {
        //         set.remove(nums[i - k]);
        //     }
        // }

        // return false;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }

}