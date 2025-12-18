# Title: Remove Duplicates from Sorted List
# Submission ID: 1859055312
# Status: Accepted
# Date: December 18, 2025 at 09:21:49 PM GMT+5:30

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return res;        
    }
}