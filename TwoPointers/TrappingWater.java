public class TrappingWater {
    static int trapBrute(int[] bars) {
        int trapped = 0;

        for (int i = 0; i < bars.length; i++) {

            int leftMax = 0;
            int rightMax = 0;

            // Find tallest bar on left
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, bars[j]);
            }

            // Find tallest bar on right
            for (int j = i; j < bars.length; j++) {
                rightMax = Math.max(rightMax, bars[j]);
            }

            int waterLevel = Math.min(leftMax, rightMax);

            trapped += waterLevel - bars[i];
        }

        return trapped;
    }

    static int prefixSuffix(int[] bars) {
        int trapped = 0;

        int[] left = new int[bars.length];
        int[] right = new int[bars.length];

        left[0] = bars[0];

        for (int i = 1; i < bars.length; i++) {
            left[i] = Math.max(left[i - 1], bars[i]);
        }

        right[right.length - 1] = bars[bars.length - 1];

        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], bars[i]);
        }

        for (int i = 0; i < bars.length; i++) {
            trapped = trapped + Math.min(left[i], right[i]) - bars[i];
        }

        return trapped;
    }

    static int twoPtrs(int[] bars) {
        int trapped = 0;

        int left = 0;
        int right = bars.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (bars[left] <= bars[right]) {
                if (leftMax > bars[left]) {
                    trapped = trapped + (leftMax - bars[left]);
                } else {
                    leftMax = bars[left];
                }
                left++;
            } else {
                if (rightMax > bars[right]) {
                    trapped = trapped + (rightMax - bars[right]);
                } else {
                    rightMax = bars[right];
                }
                right--;
            }
        }

        return trapped;
    }

    public static void main(String[] args) {
        int[] bars = { 4, 3, 1, 0, 6, 3, 2, 4, 5 };

        System.out.println(trapBrute(bars));
        System.out.println(prefixSuffix(bars));
        System.out.println(twoPtrs(bars));
    }
}
