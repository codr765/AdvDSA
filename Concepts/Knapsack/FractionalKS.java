import java.util.Arrays;

public class FractionalKS {
    static int fill(int[] value, int[] weight, int ksWeight) {
        int mx = 0;

        int[][] ratio = new int[value.length][2];

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = value[i] / weight[i];
            ratio[i][1] = weight[i];
        }

        Arrays.sort(ratio, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] is : ratio) {
            if (ksWeight >= is[1]) {
                ksWeight -= is[1];
                mx += is[1] * is[0];
            } else {
                mx += (ksWeight * is[0]);
                return mx;
            }
        }

        return mx;
    }

    public static void main(String[] args) {
        int[] value = { 30, 10, 50, 120, 150 };
        int[] weight = { 10, 10, 25, 20, 30 };
        int ksWeight = 90;

        System.out.println(fill(value, weight, ksWeight));
    }
}