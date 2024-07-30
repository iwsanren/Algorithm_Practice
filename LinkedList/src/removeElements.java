import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;

public class removeElements {
    public static void main(String[] args) {

    }

}



class SolutionA {
    /*
    当你执行 curr.next = curr.next.next; 时，你实际上是在修改链表的结构，即删除了 curr.next 所指向的节点（这个节点的值等于 val）。
    这个操作是通过改变 curr 引用所指向的节点的 next 指针来实现的，而不是通过删除 curr 引用本身。

    curr = curr.next; 这行代码的作用是将 curr 引用移动到链表的下一个节点。这并不会删除任何节点，只是改变了 curr 引用所指向的对象。
    在这个上下文中，一旦 curr.next 被设置为 curr.next.next（即删除了一个节点），curr 就需要移动到下一个有效的节点上，以便继续检查链表中的剩余部分。

    这部分难以理解的问题：
    在cur = cur.next中，cur属性val和next为什么不会变成cur.next的val和next？
    解答：
    在 cur = cur.next; 这行代码中，cur 是一个变量，它持有对链表中某个节点的引用。当你执行这行代码时，你并没有改变 cur 之前所引用的节点的任何属性（如 val 或 next），你只是改变了 cur 变量本身所持有的引用，使其指向链表中的下一个节点。
    这里有几个关键点需要理解：
    变量与引用：在Java中，变量（如 cur）不是对象本身，而是对对象在内存中位置的引用（或者说是指针）。当你将 cur 设置为 cur.next 时，你实际上是在改变 cur 变量所持有的引用，使其指向 cur.next 所引用的对象。
    对象不变性：链表中的节点（即 ListNode 对象）一旦创建，它们的 val 和 next 属性（除非在代码中显式修改）就不会因为某个变量引用的改变而改变。这是因为 val 和 next 是节点对象的属性，而不是变量的属性。
    操作结果：执行 cur = cur.next; 后，cur 现在引用的是链表中的下一个节点。但是，之前的节点（即 cur.next 之前所引用的节点）仍然存在于内存中，除非没有其他引用指向它（这时它可能会被垃圾回收器回收）。然而，这个节点的 val 和 next 属性保持不变，因为它们与 cur 变量的变化无关。
    链表结构的变化：虽然 cur 变量的引用改变了，但如果你之前通过 cur 修改了链表的结构（比如通过 cur.next = cur.next.next; 删除了一个节点），那么这种修改是持久的，并且会影响到链表的其余部分。但是，这种修改是通过操作 cur 所引用的节点的 next 属性来实现的，而不是通过改变 cur 变量本身来实现的。
    综上所述，cur = cur.next; 这行代码只会改变 cur 变量所持有的引用，而不会改变链表中任何节点的 val 或 next 属性。如果你想要修改节点的属性，你需要直接操作该节点的属性（如 cur.val = newValue; 或 cur.next = newNextNode;），而不是改变引用变量的值。
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        //这里要用while，因为可能不止一个头节点的值=target val
        //不然像case3那种情况，即head = [7,7,7,7]，val = 7，第二个7就删不掉了。
        while(head != null && head.val == val)  head = head.next;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
class solutionB{
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        //因为删除可能涉及到头节点，所以设置一个val=-1，next=head的虚拟头节点，统一操作
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while (cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}