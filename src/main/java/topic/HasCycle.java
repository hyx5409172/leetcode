package topic;

import common.ListNode;

/**
 * leetcode 141
 * */
public class HasCycle {

    public static void main(String[] args) {

    }


    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCircle = false;

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                break;
            }
            fast = fast.next;

            if(fast == slow){
                hasCircle = true;
                break;
            }
        }

        return hasCircle;
    }

}
