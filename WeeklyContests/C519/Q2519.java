// public class Q2 {

//     static boolean isPal(long num) {
//         long tmp = num;
//         long curr = 0;

//         while (tmp > 0) {
//             long rem = tmp % 10;
//             curr = curr * 10 + rem;
//             tmp /= 10;
//         }

//         return curr == num;
//     }

//     static long minOperations(int[] nums) {

//         long count = 0;

//         for (int i : nums) {

//             if (isPal(i)) {
//                 continue;
//             }

//             long add = 0;
//             long dec = 0;

//             long tmpAdd = i;
//             long tmpDec = i;

//             while (!isPal(tmpAdd)) {
//                 tmpAdd += 2;
//                 add++;
//             }

//             while (!isPal(tmpDec)) {
//                 tmpDec -= 2;
//                 dec++;
//             }

//             count += Math.min(add, dec);
//         }

//         return count;
//     }

//     public static void main(String[] args) {
//         int[] nums = { 10, 12, 14, 16 };
//         System.out.println(minOperations(nums));
//     }
// }

import java.util.*;

public class Q2519 {

    static ArrayList<Long> pals = new ArrayList<>();

    static void generatePalindromes() {

        for (long x = 1; x <= 100000; x++) {

            String s = String.valueOf(x);

            StringBuilder sb = new StringBuilder(s);

            for (int i = s.length() - 2; i >= 0; i--) {
                sb.append(s.charAt(i));
            }

            long p = Long.parseLong(sb.toString());

            if (p <= 1000000000L) {
                pals.add(p);
            }

            sb = new StringBuilder(s);

            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }

            p = Long.parseLong(sb.toString());

            if (p <= 1000000000L) {
                pals.add(p);
            }
        }

        Collections.sort(pals);
    }

    static long operations(int num) {

        long target = num;

        int lo = 0;
        int hi = pals.size();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (pals.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        long ans = Long.MAX_VALUE;

        if (lo < pals.size()) {
            long p = pals.get(lo);

            if ((p & 1) == (target & 1)) {
                ans = Math.min(ans, (p - target) / 2);
            }
        }

        if (lo > 0) {
            long p = pals.get(lo - 1);

            if ((p & 1) == (target & 1)) {
                ans = Math.min(ans, (target - p) / 2);
            }
        }

        for (int i = Math.max(0, lo - 3); i < Math.min(pals.size(), lo + 3); i++) {

            long p = pals.get(i);

            if ((p & 1) == (target & 1)) {
                ans = Math.min(ans, Math.abs(target - p) / 2);
            }
        }

        return ans;
    }

    static long minOperations(int[] nums) {

        generatePalindromes();

        long ans = 0;

        for (int num : nums) {
            ans += operations(num);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = { 10, 12, 14, 16 };

        System.out.println(minOperations(nums));
    }
}
