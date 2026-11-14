import java.util.Collections;
import java.util.PriorityQueue;

public class LC295 {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public LC295() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        left.add(num);

        right.add(left.poll());

        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}

// class MedianFinder {

// int[] freq = new int[101];
// int count = 0;

// public void addNum(int num) {
// freq[num]++;
// count++;
// }

// public double findMedian() {

// int mid1 = (count - 1) / 2;
// int mid2 = count / 2;

// int sum = 0;
// int a = -1, b = -1;

// for (int i = 0; i <= 100; i++) {

// sum += freq[i];

// if (sum > mid1 && a == -1) {
// a = i;
// }

// if (sum > mid2) {
// b = i;
// break;
// }
// }

// return (a + b) / 2.0;
// }
// }