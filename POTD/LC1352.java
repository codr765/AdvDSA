import java.util.ArrayList;

public class LC1352 {
    ArrayList<Integer> lst;

    public LC1352() {
        lst = new ArrayList<>();
        lst.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            lst.clear();
            lst.add(1);
        } else {
            lst.add(lst.get(lst.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = lst.size();

        if (k >= n) {
            return 0;
        }

        return lst.get(n - 1) / lst.get(n - k - 1);
    }
}
