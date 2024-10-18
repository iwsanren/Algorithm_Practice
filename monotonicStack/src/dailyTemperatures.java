import java.util.Arrays;
import java.util.Stack;

public class dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();//用于存放遍历过的数据
        int[] result = new int[temperatures.length];
        //先将第0个元素放入栈，用于和第一个元素对比
        st.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            //由于题目要求的是严格递增，所以当temperatures[i]小于等于栈口元素时，都要将它存入栈中。
            if (temperatures[i] <= temperatures[st.peek()]) {
                st.push(i);
            } else {
                //当temperatures[i]大于栈口元素时，弹出栈口元素。持续弹出，直到temperatures[i] <= 当前栈口元素
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    result[st.peek()] = i - st.pop();
                }
                st.push(i);
            }
        }
        return result;
    }
}

class dailyTemperaturesTest {
    public static void main(String[] args) {
        dailyTemperatures example = new dailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(example.dailyTemperatures(temperatures)));
    }
}