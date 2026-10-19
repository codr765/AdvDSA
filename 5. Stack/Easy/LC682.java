public class LC682 {
    static int calPoints(String[] operations) {
        String[] stk = new String[operations.length];
        int top = -1;

        int score = 0;

        for (int i = 0; i < operations.length; i++) {

            if (operations[i].equals("+")) {
                int a = Integer.parseInt(stk[top]);
                int b = Integer.parseInt(stk[top - 1]);

                stk[++top] = String.valueOf(a + b);

            } else if (operations[i].equals("D")) {
                int a = Integer.parseInt(stk[top]);

                stk[++top] = String.valueOf(a * 2);

            } else if (operations[i].equals("C")) {
                top--;

            } else {
                stk[++top] = operations[i];
            }
        }

        for (int i = 0; i <= top; i++) {
            score += Integer.parseInt(stk[i]);
        }

        return score;
    }

    public static void main(String[] args) {
        String[] operations = { "5", "2", "C", "D", "+" };

        System.out.println(calPoints(operations));
    }
}