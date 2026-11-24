import java.util.Arrays;

public class LC1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int ans = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++) {
            ans += costs[i][0];
        }

        for (int i = n; i < costs.length; i++) {
            ans += costs[i][1];
        }

        return ans;
    }
}