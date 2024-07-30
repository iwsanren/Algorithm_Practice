public class ListNode {
        int val;
        ListNode next;
        ListNode head;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public void PrintList(ListNode list){
                System.out.print("[ ");
                while(list != null){
                        System.out.print(list.val + " ");
                        list = list.next;
                }
                System.out.print(" ]");
        }
        public void PrintListCheck(ListNode list){
                int count = 0;
                System.out.print("[ ");
                while(list != null){
                        count++;
                        System.out.print(count + ": " +list.val + " ");
                        list = list.next;
                }
                System.out.print(" ]");
        }

        public void addAtHead(int val){
                ListNode dummy = new ListNode(100,head);
                ListNode node = new ListNode(val);
                node.next = dummy.next;
                dummy.next = node;
                this.head = dummy.next;
        }
}
