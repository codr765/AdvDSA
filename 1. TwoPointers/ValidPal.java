public class ValidPal {

    static boolean isPal(String str) {
        str = str.toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            while (left < right &&
                    !((str.charAt(left) >= 'a' && str.charAt(left) <= 'z') ||
                            (str.charAt(left) >= '0' && str.charAt(left) <= '9'))) {
                left++;
            }

            while (left < right &&
                    !((str.charAt(right) >= 'a' && str.charAt(right) <= 'z') ||
                            (str.charAt(right) >= '0' && str.charAt(right) <= '9'))) {
                right--;
            }

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";

        System.out.println(isPal(string));
    }
}
