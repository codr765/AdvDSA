// Way 1 :

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

// Way 2 :

// class MinStack {
// Stack<int[]> stk;

// public MinStack() {
// stk = new Stack<>();
// }

// public void push(int value) {
// int min = value;

// if (!stk.isEmpty()) {
// min = Math.min(value, stk.peek()[1]);
// }

// stk.push(new int[] { value, min });
// }

// public void pop() {
// stk.pop();
// }

// public int top() {
// return stk.peek()[0];
// }

// public int getMin() {
// return stk.peek()[1];
// }
// }

// Way 3 :

// class MinStack {
// Stack<int[]> stk;

// public MinStack() {
// stk = new Stack<>();
// }

// public void push(int value) {
// int min = value;

// if (!stk.isEmpty()) {
// min = Math.min(value, stk.peek()[1]);
// }

// stk.push(new int[] { value, min });
// }

// public void pop() {
// stk.pop();
// }

// public int top() {
// return stk.peek()[0];
// }

// public int getMin() {
// return stk.peek()[1];
// }
// }