import java.util.Stack;

public class revPolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //判断字符串是否相等要用.equals
            //-和/需要注意pop的位置。先出栈的是被减/除数！！
            if(tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(tokens[i].equals("-")){
                stack.push(- stack.pop() + stack.pop());
            }else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(tokens[i].equals("/")){
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2/temp1);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
class revPolishNotationTest {
    public static void main(String[] args) {
        revPolishNotation rpn = new revPolishNotation();
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(rpn.evalRPN(s));
    }
}
