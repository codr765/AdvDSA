public class LC622 {
    int[] q;
    int f = -1;
    int r = -1;
    int k;

    public LC622(int k) {
        this.k = k;
        q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            f = 0;
            r = 0;
        } else {
            r = (r + 1) % k;
        }

        q[r] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (f == r) {
            f = -1;
            r = -1;
        } else {
            f = (f + 1) % k;
        }

        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[f];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[r];
    }

    public boolean isEmpty() {
        return f == -1;
    }

    public boolean isFull() {
        return !isEmpty() && (r + 1) % k == f;
    }
}