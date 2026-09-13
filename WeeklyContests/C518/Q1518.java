class Q1 {
    public static void main(String[] args) {
        String s = "aba";
        int k = 1;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = 0;
            String tmp = s.substring(i, s.length()) + s.substring(0, i);

            for (int j = 0; j < tmp.length() - 1; j++) {
                if (tmp.charAt(j) == tmp.charAt(j + 1)) {
                    curr++;
                }
            }
            if (curr == k) {
                count++;
            }
        }

        System.out.println(count);
    }
}