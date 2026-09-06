import java.util.Arrays;

public class SortColors {

    static void sort(int[] colors) {
        int left = -1;
        int right = colors.length;
        int mid = 0;

        while (mid < right) {
            if (colors[mid] == 0) {
                int tmp = colors[mid];
                colors[mid] = colors[++left];
                colors[left] = tmp;
                mid++;
            } else if (colors[mid] == 2) {
                int tmp = colors[mid];
                colors[mid] = colors[--right];
                colors[right] = tmp;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] colors = { 2, 0, 2, 1, 1, 0 };

        sort(colors);

        System.out.println(Arrays.toString(colors));
    }
}
