# Title: Add Two Numbers
# Submission ID: 1702835266
# Status: Accepted
# Date: July 19, 2025 at 01:33:28 AM GMT+5:30

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Deserialize a string like "[2,4,3]" into a ListNode
    public static ListNode deserialize(String s) {
        s = s.replaceAll("\\[|\\]|\\s", "");
        if (s.isEmpty()) return null;

        String[] parts = s.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }

        return dummy.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    // Helper to print the result
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.print("Output: ");
        printList(result);
    }
}
