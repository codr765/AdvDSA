public class LC1343 {
    static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >= k) {
                sum -= arr[i - k];
            }

            if (i >= k - 1 && sum >= threshold * k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
        int k = 3;
        int threshold = 4;

        System.out.println(numOfSubarrays(arr, k, threshold));
    }
}
