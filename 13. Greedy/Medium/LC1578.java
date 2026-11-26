public class LC1578 {
    public int minCost(String colors, int[] neededTime) {
        int ct = 0;

        for (int i = 1; i < neededTime.length; i++) {

            if (colors.charAt(i) == colors.charAt(i - 1)) {
                ct += Math.min(neededTime[i], neededTime[i - 1]);

                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return ct;
    }
}
