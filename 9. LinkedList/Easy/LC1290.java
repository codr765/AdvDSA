public class LC1290 {
    public int getDecimalValue(ListNode head) {
        int dcml = 0;

        while (head != null) {
            dcml = dcml * 2 + head.val;
            head = head.next;
        }

        return dcml;
    }
}