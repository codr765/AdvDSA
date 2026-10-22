public class LC641 {
    int[] q;
    int f = -1;
    int r = -1;
    int k;

    public LC641(int k) {
        this.k = k;
        q = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            f = r = 0;
        } else {
            f = (f - 1 + k) % k;
        }

        q[f] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            f = r = 0;
        } else {
            r = (r + 1) % k;
        }

        q[r] = value;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        if (f == r) {
            f = r = -1;
        } else {
            f = (f + 1) % k;
        }

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        if (f == r) {
            f = r = -1;
        } else {
            r = (r - 1 + k) % k;
        }

        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q[f];
    }

    public int getRear() {
        return isEmpty() ? -1 : q[r];
    }

    public boolean isEmpty() {
        return f == -1;
    }

    public boolean isFull() {
        return !isEmpty() && (r + 1) % k == f;
    }
}