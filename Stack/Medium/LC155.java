public class LC155 {
    static int[] stk = new int[100000];
    static int[] tmp = new int[100000];
    static int top = -1;

    LC155() {
        stk = new int[100000];
        tmp = new int[100000];
        top = -1;
    }

    static void push(int value) {
        stk[++top] = value;

        if (top == 0) {
            tmp[top] = value;
        } else {
            tmp[top] = Math.min(tmp[top - 1], value);
        }
    }

    static void pop() {
        top--;
    }

    static int top() {
        return stk[top];
    }

    static int getMin() {
        return tmp[top];
    }

    public static void main(String[] args) {
        push(-2);
        push(0);
        push(-3);

        System.out.println(getMin());
        pop();
        System.out.println(getMin());
    }
}
