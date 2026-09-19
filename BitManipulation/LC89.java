import java.util.ArrayList;
import java.util.List;

public class LC89 {

    static List<Integer> grayCode(int n) {

        List<Integer> ans = new ArrayList<>();

        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            ans.add(i ^ (i >> 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(grayCode(n));
    }
}
