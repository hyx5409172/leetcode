package topic;

import common.ListNode;

/**
 * leetcode 24
 * */
public class SwapPairs {

    private ListNode pre = null;

    public ListNode swapPairs(ListNode head) {
        ListNode curNode = head;
        ListNode newHead = head!= null && head.next != null? head.next:head;

        while(curNode != null && curNode.next != null){

            ListNode curNext = curNode.next;
            curNode.next = curNext.next;
            curNext.next = curNode;
            if(pre != null){
                pre.next = curNext;
            }

            pre = curNode;
            curNode = curNode.next;
        }

        return newHead;
    }

}
