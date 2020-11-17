package topic;

import common.ListNode;

import java.util.Stack;

public class A143_reorderList {

    public static void main(String[] args) {
        A143_reorderList a143_reorderList = new A143_reorderList();
        int [] arr = {1,2,3,4};
        ListNode head = ListNode.arrToListNode(arr);

//        a143_reorderList.reorderList(head);
        a143_reorderList.process(head);
        System.out.println(head);
    }

    // 3ms
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        Stack<ListNode> stack = new Stack<>();
        boolean odds = false;

        while(fast != null){
            // debug
            System.out.println("slow:" + slow);
            // debug
            System.out.println("fast:" + fast);
            stack.push(slow);
            slow = slow.next;
            fast = fast.next;
            if(fast == null){
                odds = true;
                break;
            }
            fast = fast.next;
        }
        // debug
        System.out.println("middle:" + slow);

        if(odds){
            // debug
            System.out.println("odds! pop:" + stack.peek());
            stack.pop();
        }


        fast = slow;
        slow = slow.next;
        fast.next = null;
        fast = slow;

        ListNode temp = null;
        ListNode tempNext = null;
        while(slow != null){

            fast = fast.next;

            temp = stack.pop();
            // debug
            System.out.println();
            System.out.println("pop: " + temp);
            System.out.println("slow: " + slow);
            System.out.println("fast: " + fast);

            tempNext = temp.next;
            temp.next = slow;
            slow.next = tempNext;

            slow = fast;
        }


        // debug
        System.out.println("head: " + head);

    }

    // 553ms 加个公共stack来避免每次找end可能好些
    public void process(ListNode node){
        // 仅剩一个节点
        if(node.next == null){
            return;
        }

        ListNode preEnd = node;
        ListNode end = node.next;
        while(end.next != null){
            end = end.next;
            preEnd = preEnd.next;
        }

        // 仅剩2个节点
        if(end == node.next){
            return;
        }

        end.next = node.next;
        node.next = end;
        preEnd.next = null;

        process(end.next);
    }

    // 1ms
    public void nativeFastWay(ListNode head){
        if (head == null) return;

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length ++;
            node = node.next;
        }

        node = head;
        ListNode[] nodes = new ListNode[length];
        for(int i =0; i < length; i++){
            nodes[i] = node;
            node = node.next;
        }

        int i = 0, j = length - 1;
        while (i < j) {
            nodes[i].next = nodes[j];
            i += 1;
            if (i == j) break;
            nodes[j].next = nodes[i];
            j -= 1;
        }
        nodes[i].next = null;
    }
}
