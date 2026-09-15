import java.util.ArrayList;
import java.util.List;

public class LC438 {
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int[] hash2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            hash2[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {

            int[] hash1 = new int[26];

            String tmp = s.substring(i, i + p.length());

            for (int j = 0; j < tmp.length(); j++) {
                hash1[tmp.charAt(j) - 'a']++;
            }

            boolean found = true;

            for (int j = 0; j < 26; j++) {
                if (hash1[j] != hash2[j]) {
                    found = false;
                    break;
                }
            }

            if (found) {
                list.add(i);
            }

        }

        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}