import java.util.Stack;

public class deAdjacentDuplicates {
    //效率太低
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() || s.charAt(i) != stack.peek()){
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        String s2 = "";
        while(!stack.isEmpty()){
            s2 = stack.pop() + s2;
        }
        return s2;
    }
    //dual-pointer
    public String removeDuplicates1(String s) {
        char[] c = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while(fast < s.length()){
            c[slow] = c[fast];
            //相邻元素相等，慢指针回退
            if(slow > 0 && c[slow] == c[slow-1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(c,0,slow);
    }
}
class deAdjacentDuplicatesTest {
    public static void main(String[] args) {
        deAdjacentDuplicates dad = new deAdjacentDuplicates();
        System.out.println(dad.removeDuplicates1("abbaca"));
    }
}
