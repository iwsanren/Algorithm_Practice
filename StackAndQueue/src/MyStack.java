import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    Deque<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offerLast(x);
    }

    public int pop() {
        // Removes the element on the top of the stack and returns it.
        //method: return queue.pollLast;
        int size = queue.size();
        while(size > 1){
            queue.offerLast(queue.pollFirst());
            size--;
        }
        return queue.pollFirst();
    }

    public int top() {
        //int top() Returns the element on the top of the stack.
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
