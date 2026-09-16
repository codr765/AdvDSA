public class LC1052 {

    static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int mx = 0;
        int mx2 = 0;
        int mxGrumpy = 0;

        for (int i = 0; i < customers.length; i++) {

            if (grumpy[i] == 1) {
                mxGrumpy += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                mxGrumpy -= customers[i - minutes];
            }

            if (mxGrumpy > mx2) {
                mx2 = mxGrumpy;
            }
        }

        for (int i = 0; i < customers.length; i++) {

            if (grumpy[i] == 0) {
                mx += customers[i];
            }
        }

        return mx + mx2;
    }

    public static void main(String[] args) {

        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
}