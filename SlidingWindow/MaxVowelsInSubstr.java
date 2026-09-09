public class MaxVowelsInSubstr {

    static int maxVowels(String s, int k) {
        // int count = 0;

        // int[] hash = new int[s.length()];

        // for (int i = 0; i < s.length(); i++) {

        // if (i == 0) {
        // hash[i] = 0;
        // } else {
        // hash[i] = hash[i - 1];
        // }

        // if (s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
        // s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
        // s.charAt(i) == 'u') {

        // hash[i]++;
        // }
        // }

        // for (int i = k; i < hash.length; i++) {
        // count = Math.max(count, hash[i] - hash[i - k]);
        // }

        // return count;

        int count = 0;

        for (int i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }

        int max = count;

        for (int i = k; i < s.length(); i++) {
            if ("aeiou".indexOf(s.charAt(i)) != -1) {
                count++;
            }

            if ("aeiou".indexOf(s.charAt(i - k)) != -1) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowels(s, k));

    }
}
