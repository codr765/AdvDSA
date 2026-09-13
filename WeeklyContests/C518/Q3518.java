public class Q3 {
    public static void main(String[] args) {
        int[] position = { 1, 5, 6, 20 };
        int[] speed = { 4, 3, 2, 3 };
        int distance = 1;

        int groups = 1;

        int[] group = new int[speed.length];

        int index = 0;

        group[index++] = speed[speed.length - 1];

        for (int i = speed.length - 2; i >= 0; i--) {
            if (position[i+1] - position[i] <= distance) {
                continue;
            }

            group[index++] = speed[i];
        }

        int rightSpeed = group[0];

        for (int i = 0; i < speed.length; i++) {
            int leftSpeed = group[i];

            if (leftSpeed > rightSpeed) {
                
            }
            else {
                groups++;
                rightSpeed = leftSpeed;
            }
        }

        System.out.println(groups);
    }
}
