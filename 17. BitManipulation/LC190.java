public class LC190 {

    static int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < 32; i++) {

            int lastBit = n & 1;

            n = n >>> 1;

            rev = rev | (lastBit << (31 - i));
        }

        return rev;
    }

    public static void main(String[] args) {
        int n = 43261596;

        System.out.println(reverseBits(n));
    }
}