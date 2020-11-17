package topic;

import common.ListNode;

/**
 * leetcode 2
 * */
public class AddTwoNumbers {

    public static void main(String[] args) {
        int[] arr1 = {9,9,9,9,9,9,9};
        int[] arr2 = {9,9,9,9};

        AddTwoNumbers a = new AddTwoNumbers();
        System.out.println(a.addTwoNumbers(ListNode.arrToListNode(arr1), ListNode.arrToListNode(arr2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null,preNode = null, curNode = null;

        int cur = 0, carry = 0, lVal = 0, rVal = 0;
        while(l1 != null || l2 != null || carry != 0){
            lVal = l1 == null? 0 : l1.val;
            rVal = l2 == null? 0 : l2.val;
            l1 = l1 == null? null :l1.next;
            l2 = l2 == null? null :l2.next;

            cur = lVal + rVal + carry;
            if(cur > 9){
                cur %= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            curNode = new ListNode(cur);
            if(root == null){
                root = curNode;
            } else {
                preNode.next = curNode;
            }
            preNode = curNode;
        }

        return root;
    }



}
