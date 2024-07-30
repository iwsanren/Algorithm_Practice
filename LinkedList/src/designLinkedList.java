public class designLinkedList {
    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
//        System.out.println(myLinkedList.get(1));              // return 2
//        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
//        System.out.println(myLinkedList.get(1));              // return 3
        MyLinkedList2 myLinkedList2 = new MyLinkedList2();
        myLinkedList2.addAtHead(1);
        myLinkedList2.addAtHead(2);
        myLinkedList2.addAtHead(3);
        System.out.println(myLinkedList2.get(0));
        System.out.println(myLinkedList2.get(1));
        System.out.println(myLinkedList2.get(2));

    }
}

class MyLinkedList {
    int size;//list长度
    ListNode head;//原头节点
    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(100);
    }
    public int get(int index) {
        if(index<0 || index >= size){
            return -1;
        }
        //ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        //为什么这里是<=?假如index = 0,那无需进入循环，直接返回head的val就可以了吧
        //因为MyLinkedList初始化的时候定义了一个值为100的虚拟初始头节点，所以自动往后取一个。
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    public void addAtHead(int val) {
        ListNode cur = head;
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index < 0){
            index = 0;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }
    public void deleteAtIndex(int index) {
        if(index<0 || index > size-1){
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }
}

class MyLinkedList2 {
    int size;
    ListNode head;
    public MyLinkedList2() {
        int size = 0;
        head = new ListNode();
    }
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        //ListNode dummy = new ListNode(-1,head);
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    public void addAtHead(int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size++;
        this.head = dummy.next;
    }
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index<0){
            index = 0;
        }
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next = node;
        size++;

    }
    public void deleteAtIndex(int index) {		}
}





