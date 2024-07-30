public class cycle {
    public static void main(String[] args) {
        ListNode lsA = new ListNode();
        ListNode lsB = new ListNode();
        ListNode lsC = new ListNode();

        lsA.addAtHead(6);
        lsA.addAtHead(5);
        lsA.addAtHead(4);
        lsA.addAtHead(3);
        lsA.addAtHead(2);
        lsA.addAtHead(1);

        lsB.addAtHead(102);
        lsB.addAtHead(101);
        lsB.addAtHead(100);

        lsC.addAtHead(10002);
        lsC.addAtHead(10001);
        lsC.addAtHead(10000);

        // 将节点连接成循环链表
        // lsC -> lsB -> lsC -> lsA
        lsA.head.next = lsB.head;
        lsB.head.next = lsC.head;
        lsC.head.next = lsA.head; // 最后一个节点指向第一个节点，形成循环

//        ListNode current = lsA.head;
//        int count = 0;
//        do {
//            System.out.println(current.val);
//            current = current.next;
//            count++;
//            // 为了避免无限循环，这里我们假设链表有3个节点
//            if (count > 3) {
//                break;
//            }
//        } while (current != lsA.head); // 假设我们知道循环点，但在实际中可能不知道
//
//        lsA.head.PrintList(lsA.head);



    }
}

class listCycle{
//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while(fast != null && fast.next != null){
//            fast = fast.next.next;
//            slow = slow.next;
//            while(fast == slow){
//                ListNode index1 = fast;
//                ListNode index2 = head;
//                while(index1 != index2){
//                    index1 = index1.next;
//                    index2 = index2.next;
//                }
//                return index1;
//            }
//        }
//        return null;
//    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            while(fast == slow){
                ListNode index1 = head;
                ListNode index2 = slow;
                while(index1 != index2){
                index1 = index1.next;
                index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }



}