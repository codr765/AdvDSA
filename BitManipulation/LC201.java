public class LC201 {
    static int rangeBitwiseAnd(int left, int right) {
        int shifts = 0;

        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shifts++;
        }

        return left << shifts;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(4, 7));
    }
}
