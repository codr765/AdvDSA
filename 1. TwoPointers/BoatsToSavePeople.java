import java.util.Arrays;

public class BoatsToSavePeople {
    static int numRescueBoats(int[] people, int limit) {
        int count = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                count++;
            } else {
                right--;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] people = { 3, 5, 3, 4 };
        int limit = 5;

        System.out.println(numRescueBoats(people, limit));
    }
}
