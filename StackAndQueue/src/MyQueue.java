import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void push(int x) {
        this.stackIn.push(x);
    }

    public int pop() {
        this.dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        this.dumpStackIn();
//        int i = stackOut.pop();
//        stackOut.push(i);
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.empty() && stackIn.empty();
    }
    //stackOut不为空，则不做操作。stackOot为空，则把stackIn的所有元素都pop进去
    private void dumpStackIn(){
        if(!stackOut.empty()) return;
        while(!stackIn.empty()){
            stackOut.push(stackIn.pop());
        }
    }
}
