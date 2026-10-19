import java.util.HashMap;

public class LC904 {
    static int totalFruitHashMap(int[] fruits) {
        int total = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int left = 0;

        for (int right = 0; right < fruits.length; right++) {

            hashMap.put(fruits[right], hashMap.getOrDefault(fruits[right], 0) + 1);

            while (hashMap.size() > 2) {

                int leftFruit = fruits[left];

                hashMap.put(leftFruit, hashMap.get(leftFruit) - 1);

                if (hashMap.get(leftFruit) == 0) {
                    hashMap.remove(leftFruit);
                }

                left++;
            }

            total = Math.max(total, right - left + 1);
        }

        return total;
    }

    static int totalFruit(int[] fruits) {
        int total = 0;
        int[] hash = new int[fruits.length];

        int left = 0;
        int types = 0;

        for (int right = 0; right < hash.length; right++) {
            if (hash[fruits[right]] == 0) {
                types++;
            }

            hash[fruits[right]]++;

            while (types > 2) {

                hash[fruits[left]]--;

                if (hash[fruits[left]] == 0) {
                    types--;
                }

                left++;
            }

            total = Math.max(total, right - left + 1);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 3, 2, 2 };

        // System.out.println(totalFruitHashMap(fruits));

        System.out.println(totalFruit(fruits));

    }
}
