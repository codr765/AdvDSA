import java.util.Stack;

public class LC739 {
    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] greater = new int[n];

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int prevIndex = stk.pop();
                greater[prevIndex] = i - prevIndex;
            }

            stk.push(i);
        }

        return greater;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(dailyTemperatures(temperatures));
    }
}
