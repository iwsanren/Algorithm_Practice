public class intersectionOfTwoLists {
    public static void main(String[] args) {
        ListNode lsA = new ListNode();
        ListNode lsB = new ListNode();
        lsB.addAtHead(6);
        lsB.addAtHead(5);

//        lsA.addAtHead(4);
//        lsA.addAtHead(3);
//        lsA.addAtHead(2);
        lsA.addAtHead(1);
        lsA.head.next = lsB.head;

        lsA.head.PrintList(lsA.head);
        lsB.head.PrintList(lsB.head);

        intersection is = new intersection();
        ListNode rs = is.getIntersectionNode(lsA.head,lsB.head);
        rs.PrintList(rs);
    }

}
class intersection{
    ListNode head;
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while(curA != null){
            lengthA++;
            curA = curA.next;
        }
        while(curB != null){
            lengthB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        //let headA longer
        if(lengthB > lengthA){
            int tempLength = lengthA;
            lengthA = lengthB;
            lengthB = tempLength;
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        int gapLength = lengthA-lengthB;
        while (gapLength > 0){
            curA = curA.next;
            gapLength--;
        }
        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

}