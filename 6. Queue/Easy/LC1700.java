class Solution {
    public int countStudentsBrute(int[] students, int[] sandwiches) {

        int n = students.length;
        int unable = n;
        int top = 0;

        while (top < n) {

            boolean found = false;

            for (int i = 0; i < n; i++) {

                if (students[i] != -1 && students[i] == sandwiches[top]) {

                    found = true;
                    unable--;

                    students[i] = -1;
                    top++;

                    break;
                }
            }

            if (!found) {
                return unable;
            }
        }

        return 0;
    }
}