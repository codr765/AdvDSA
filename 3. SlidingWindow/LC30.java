import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC30 {

    static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> list = new ArrayList<>();

        int wordSize = words[0].length();
        int wordCount = words.length;

        HashMap<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordSize; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            HashMap<String, Integer> current = new HashMap<>();

            while (right + wordSize <= s.length()) {

                String word = s.substring(right, right + wordSize);
                right += wordSize;

                if (!required.containsKey(word)) {
                    current.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                current.put(word, current.getOrDefault(word, 0) + 1);
                count++;

                while (current.get(word) > required.get(word)) {

                    String leftWord = s.substring(left, left + wordSize);
                    current.put(leftWord, current.get(leftWord) - 1);

                    left += wordSize;
                    count--;
                }

                if (count == wordCount) {
                    list.add(left);

                    String leftWord = s.substring(left, left + wordSize);
                    current.put(leftWord, current.get(leftWord) - 1);

                    left += wordSize;
                    count--;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {

        String s = "barfoothefoobarman";
        String[] words = { "foo", "bar" };

        System.out.println(findSubstring(s, words));
    }
}