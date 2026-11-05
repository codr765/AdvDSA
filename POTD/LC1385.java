public class LC1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);

        int ct = 0;

        for (int x : arr1) {
            int left = 0;
            int right = arr2.length - 1;
            boolean valid = true;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (Math.abs(x - arr2[mid]) <= d) {
                    valid = false;
                    break;
                }

                if (arr2[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (valid) {
                ct++;
            }
        }

        return ct;
    }
}