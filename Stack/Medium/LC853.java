import java.util.Arrays;
import java.util.Stack;

public class RemLC853 {
    static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        Stack<Double> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if (stk.isEmpty() || time > stk.peek()) {
                stk.push(time);
            }
        }

        return stk.size();
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };

        System.out.println(carFleet(target, position, speed));
    }
}
