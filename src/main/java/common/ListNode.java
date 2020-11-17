package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String res = String.valueOf(val);
        if(next != null){
            res += " -> ";
            res += next.toString();
        }
        return res;

    }

    public static ListNode arrToListNode(int[] arr){
        ListNode root = new ListNode(arr[0]);
        ListNode node = root, newNode = null;
        for (int i = 1,length = arr.length; i < length; i++) {
            newNode = new ListNode(arr[i]);
            node.next = newNode;
            node = newNode;
        }

        return root;
    }
}
