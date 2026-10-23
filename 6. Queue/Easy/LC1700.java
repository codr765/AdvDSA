public class LC1700 {
    public int ctStudents(int[] students, int[] sandwiches) {

        int[] ct = new int[2];

        for (int s : students) {
            ct[s]++;
        }

        for (int s : sandwiches) {

            if (ct[s] == 0) {
                return ct[0] + ct[1];
            }

            ct[s]--;
        }

        return 0;
    }

    public int ctStudentsBrute(int[] students, int[] sandwiches) {

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