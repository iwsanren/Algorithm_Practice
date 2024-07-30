public class removeNthNode {
    ListNode head;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(100,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n+1; i++) {
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
    public void addAtHead(int val){
        ListNode dummy = new ListNode(100,head);
        ListNode node = new ListNode(val);
        node.next = dummy.next;
        dummy.next = node;
        this.head = dummy.next;
    }
}
class test{
    public static void main(String[] args) {
        removeNthNode rnn = new removeNthNode();
        rnn.addAtHead(4);
        rnn.addAtHead(3);
        rnn.addAtHead(2);
        rnn.addAtHead(1);
        ListNode node = rnn.head;
        node.PrintList(node);
        ListNode node2 = rnn.removeNthFromEnd(node,2);
        node2.PrintList(node2);
    }

}