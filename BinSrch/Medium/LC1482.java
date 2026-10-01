class LC1482 {
    static int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = 1;
        int right = bloomDay[0];

        for (int i : bloomDay) {
            right = Math.max(right, i);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int ct = 0;
            int tmp = 0;

            for (int i : bloomDay) {
                if (i <= mid) {
                    tmp++;

                    if (tmp == k) {
                        ct++;
                        tmp = 0;
                    }
                } else {
                    tmp = 0;
                }
            }

            if (ct >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}