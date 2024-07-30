public class reverseLinkedList {
    public static void main(String[] args) {
        reverse reverse = new reverse();
        reverse.addAtHead(3);
        reverse.addAtHead(2);
        reverse.addAtHead(1);
        ListNode node = reverse.reverseList(reverse.head);
        reverse.PrintList(node);
    }
}

class reverse {
    ListNode head;
    public ListNode reverseList(ListNode head) {
//        1.dual pointer
//        ListNode cur = head;
//        ListNode pre = null;
//        while(cur != null){
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
//=========================================================================
        //2.recursion
        return reverse(head,null);
    }
    public ListNode reverse(ListNode cur, ListNode pre){
        if(cur == null)return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp,cur);
    }
    public void addAtHead(int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        this.head = dummy.next;
    }
    public void PrintList(ListNode list){
        System.out.print("[ ");
        while(list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.print(" ]");
    }
}