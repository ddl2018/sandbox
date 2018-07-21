package min.datastructurenalgorithm.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(-1);
        ListNode current = new ListNode(-1);
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        }
        int i = 0;
        while (l2 != null || l1 != null) {
            ListNode newNode = new ListNode(-1);
            if (l1 != null && l2 != null){
                if (l1.val <= l2.val) {
                    newNode = l1;
                    l1 = l1.next;
                } else if (l2.val <= l1.val) {
                    newNode = l2;
                    l2 = l2.next;
                }
            }else if (l1 == null && l2 != null) {
                newNode = l2;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                newNode = l1;
                l1 = l1.next;
            }
            if (i == 0) {
                i++;
                resultHead = newNode;
                current = newNode;
            } else {
                current.next = newNode;
                current = newNode;
            }
        }
        return resultHead;
    }
}
