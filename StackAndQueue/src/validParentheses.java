import java.util.Stack;

public class validParentheses {
    //Parentheses 小括号
    public boolean isValid(String s) {
        //剪枝
        if(s.length()%2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(')');
            }else if(s.charAt(i) == '{'){
                stack.push('}');
            }else if(s.charAt(i) == '['){
                stack.push(']');
            }else if(stack.isEmpty() || s.charAt(i) != stack.peek()){//这里需要注意的是，要让字符串和stack.peek作比较，而不是pop。不然的话每次做完比较stack都会少一个元素。
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
class validParenthesesTest {
    public static void main(String[] args) {
        validParentheses vp = new validParentheses();
        System.out.println(vp.isValid("()"));
        System.out.println(vp.isValid("{(]}"));
        System.out.println(vp.isValid("{[(])}"));
        System.out.println(vp.isValid("(({[(])}"));
        System.out.println(vp.isValid("]"));
    }
}