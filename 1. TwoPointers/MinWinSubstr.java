public class MinWinSubstr {

    static String minWindowBrute(String s, String t) {

        String window = "";

        for (int start = 0; start < s.length(); start++) {

            for (int end = start; end < s.length(); end++) {

                String tmp = s.substring(start, end + 1);

                int count = 0;

                boolean[] used = new boolean[tmp.length()];

                for (int k = 0; k < t.length(); k++) {

                    for (int l = 0; l < tmp.length(); l++) {

                        if (!used[l] && t.charAt(k) == tmp.charAt(l)) {

                            used[l] = true;
                            count++;

                            break;
                        }
                    }
                }

                if (count == t.length()) {

                    if (window.isEmpty() ||
                            tmp.length() < window.length()) {

                        window = s.substring(start, end + 1);
                    }
                }
            }
        }

        return window;
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindowBrute(s, t));
    }
}
