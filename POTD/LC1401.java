public class LC1401 {
    static boolean checkOverlap(int radius, int xCenter, int yCenter,
            int x1, int y1, int x2, int y2) {

        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        int dx = closestX - xCenter;
        int dy = closestY - yCenter;

        return dx * dx + dy * dy <= radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(checkOverlap(1, -1, 0, 0, 0, 0, 1));
    }
}
