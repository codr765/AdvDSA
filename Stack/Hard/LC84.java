import java.util.Stack;

public class LC84 {
    static int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int curr = (i == heights.length) ? 0 : heights[i];

            while (!stk.isEmpty() && heights[stk.peek()] > curr) {

                int height = heights[stk.pop()];

                int right = i;

                int left = stk.isEmpty() ? -1 : stk.peek();

                int width = right - left - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stk.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };

        System.out.println(largestRectangleArea(heights));
    }
}
