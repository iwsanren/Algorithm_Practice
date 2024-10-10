public class SwapNode {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.addAtHead(4);
        s.addAtHead(3);
        s.addAtHead(2);
        s.addAtHead(1);
        ListNode head = s.head;
        s.head.PrintList(head);
        s.head.PrintList(s.swapPairs(head));
    }

}
class Solution {
    ListNode head;
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(100,head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;//cur的指针指向2号
            cur.next.next = temp1;//2号的指针指向1号，此时2号是cur.next
            temp1.next = temp2;//1号的指针指向3
            cur = cur.next.next;
        }
        return dummy.next;

    }
    public void addAtHead(int val){
        ListNode dummy = new ListNode(100,head);
        ListNode node = new ListNode(val);
        node.next = dummy.next;
        dummy.next = node;
        this.head = dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode cur = dummyhead;
        while(cur.next != null && cur.next.next != null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;

            cur = temp1;
        }
        return dummyhead.next;

    }













}