import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    Stack<Integer> stk;
    ArrayList<Integer> list;

    public StockSpanner() {
        stk = new Stack<>();
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);

        int i = list.size() - 1;

        while (!stk.isEmpty() && list.get(stk.peek()) <= price) {
            stk.pop();
        }

        int span = stk.isEmpty() ? i + 1 : i - stk.peek();

        stk.push(i);

        return span;
    }
}

public class LC901 {
    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
