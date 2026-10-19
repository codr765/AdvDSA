import java.util.ArrayList;
import java.util.List;

public class LC3211 {

    static void generate(int n, String str, List<String> ans) {

        if (str.length() == n) {
            ans.add(str);
            return;
        }

        generate(n, str + "1", ans);

        if (str.length() == 0 || str.charAt(str.length() - 1) != '0') {
            generate(n, str + "0", ans);
        }
    }

    static List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();

        generate(n, "", ans);

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println(validStrings(n));
    }
}
