package topic;

import common.ListNode;

public class A234_isPalindrome {


    public static void main(String[] args) {
        A234_isPalindrome a234_isPalindrome = new A234_isPalindrome();
        int[] arr = {0,0};
        ListNode head = ListNode.arrToListNode(arr);

        System.out.println(a234_isPalindrome.revertWay(head));
    }

    // 哈希公式法更简洁，并且不修改输入
    public boolean isPalindrome(ListNode head) {
        return revertWay(head);
    }

    public boolean revertWay(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = pre;

        boolean odd = true;
        while(fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                odd = false;
                break;
            }
            fast = fast.next;
        }

        slow = odd?slow:pre;
        pre = odd?slow:slow.next;

        ListNode node = pre.next;
        ListNode next = null;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        slow.next = null;

        slow = head;
        node = pre;
        while(slow != null){
            if(slow.val != node.val){
                return false;
            }
            slow = slow.next;
            node = node.next;
        }

        return true;
    }

}
