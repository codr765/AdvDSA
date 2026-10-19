public class LC327 {
    static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] temp = new long[n + 1];

        return (int) mergeSort(prefix, temp, 0, n, lower, upper);
    }

    static long mergeSort(long[] arr, long[] temp, int left, int right,
            int lower, int upper) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        long count = 0;

        count += mergeSort(arr, temp, left, mid, lower, upper);
        count += mergeSort(arr, temp, mid + 1, right, lower, upper);

        int low = mid + 1;
        int high = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (low <= right && arr[low] - arr[i] < lower) {
                low++;
            }

            while (high <= right && arr[high] - arr[i] <= upper) {
                high++;
            }

            count += high - low;
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = left; x <= right; x++) {
            arr[x] = temp[x];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 5, -1 };
        int lower = -2;
        int upper = 2;

        System.out.println(countRangeSum(nums, lower, upper));
    }
}