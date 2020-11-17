package topic;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 19
 * */
public class A19_RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        Map<Integer, ListNode> cat = new HashMap<>();
        int index = 0;
        while (node != null){
            cat.put(index, node);
            index ++;
            node = node.next;
        }

        index = index - n - 1;
        if(index < 0){
            head = head.next;
        } else {
            node = cat.get(index);
            node.next = node.next.next;
        }


        return head;
    }

}
