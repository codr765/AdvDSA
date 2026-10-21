class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}

// class Solution {
// public int timeRequiredToBuy(int[] tickets, int k) {
// int time = 0;
// int curr = 0;

// while (tickets[k] > 0) {
// if (curr == tickets.length) {
// curr = 0;
// }

// if (tickets[curr] == 0) {
// curr++;
// continue;
// }

// tickets[curr]--;
// time++;
// curr++;
// }

// return time;
// }
// }