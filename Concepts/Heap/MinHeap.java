import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class MinHeap {

    static ArrayList<Integer> heap = new ArrayList<>();

    // PARENT
    static int parent(int i) {
        return (i - 1) / 2;
    }

    // LEFT CHILD
    static int left(int i) {
        return 2 * i + 1;
    }

    // RIGHT CHILD
    static int right(int i) {
        return 2 * i + 2;
    }

    // INSERT
    static void insert(int val) {

        heap.add(val);

        int i = heap.size() - 1;

        while (i > 0 && heap.get(i) < heap.get(parent(i))) {

            Collections.swap(heap, i, parent(i));

            i = parent(i);
        }
    }

    // PEEK
    static int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    // DELETE MINIMUM
    static int delete() {

        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int min = heap.get(0);

        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    // HEAPIFY DOWN
    static void heapifyDown(int i) {

        int smallest = i;

        int l = left(i);
        int r = right(i);

        if (l < heap.size() &&
                heap.get(l) < heap.get(smallest)) {

            smallest = l;
        }

        if (r < heap.size() &&
                heap.get(r) < heap.get(smallest)) {

            smallest = r;
        }

        if (smallest != i) {

            Collections.swap(heap, i, smallest);

            heapifyDown(smallest);
        }
    }

    // BUILD HEAP
    static void buildHeap(int[] arr) {

        heap.clear();

        for (int num : arr) {
            heap.add(num);
        }

        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // DISPLAY
    static void display() {
        System.out.println(heap);
    }

    public static void main(String[] args) {

        insert(40);
        insert(20);
        insert(50);
        insert(10);
        insert(30);

        System.out.print("Min Heap: ");
        display();

        System.out.println("Peek: " + peek());

        System.out.println("Deleted: " + delete());

        System.out.print("After Deletion: ");
        display();

        int[] arr = { 60, 20, 10, 40, 30, 50 };

        buildHeap(arr);

        System.out.print("Built Heap: ");
        display();
    }
}