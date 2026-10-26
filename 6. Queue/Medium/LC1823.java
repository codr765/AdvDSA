// public class LC1823 {
//     public int findTheWinner(int n, int k) {
//         int[] nums = new int[n];

//         for (int i = 0; i < n; i++) {
//             nums[i] = i + 1;
//         }

//         int idx = 0;

//         while (n > 1) {
//             int ct = 0;

//             while (ct < k) {
//                 if (nums[idx] != 0) {
//                     ct++;
//                 }

//                 if (ct == k) {
//                     nums[idx] = 0;
//                     n--;
//                     break;
//                 }

//                 idx = (idx + 1) % nums.length;
//             }

//             while (nums[idx] == 0) {
//                 idx = (idx + 1) % nums.length;
//             }
//         }

//         return nums[idx];
//     }
// }

// class Solution {
//     public int findTheWinner(int n, int k) {
//         Queue<Integer> q = new LinkedList<>();

//         for (int i = 1; i <= n; i++) {
//             q.offer(i);
//         }

//         while (q.size() > 1) {
//             for (int i = 1; i < k; i++) {
//                 q.offer(q.poll());
//             }

//             q.poll();
//         }

//         return q.peek();
//     }
// }

public class LC1823 {
    public int findTheWinner(int n, int k) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = (ans + k) % i;
        }

        return ans + 1;
    }
}