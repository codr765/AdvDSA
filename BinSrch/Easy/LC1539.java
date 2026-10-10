public class LC1539 {
    static int findKthPositiveBrute(int[] arr, int k) {

        int n = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > i + 1) {
                n = arr[i] - i - 1;
            }

            if (n >= k) {
                return arr[i] - (n - k) - 1;
            }
        }

        return arr[arr.length - 1] + k - n;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 7, 11 };
        int k = 5;

        System.out.println(findKthPositiveBrute(arr, k));
    }
}
