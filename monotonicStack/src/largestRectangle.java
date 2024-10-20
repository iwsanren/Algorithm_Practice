import java.util.Stack;

public class largestRectangle {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length-1] = 0;
        for (int i = 1; i < newHeights.length-1; i++) {
            newHeights[i] = heights[i-1];
        }

        int maxArea = 0;

        for (int i = 1; i < newHeights.length; i++) {
            if(newHeights[i] > newHeights[stack.peek()]){
                stack.push(i);
            }else if(newHeights[i] == newHeights[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]){
                    int mid = stack.peek();
                    stack.pop();
                    if(!stack.isEmpty()){
                        int left = stack.peek();
                        int right = i;
                        int w = right - left - 1;
                        int h = newHeights[mid];
                        maxArea = Math.max(maxArea, w * h);
                    }
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}
class largestRectangleTest {
    public static void main(String[] args) {
        largestRectangle example = new largestRectangle();
        int[] heights = {1,2,2};
        System.out.println(example.largestRectangleArea(heights));
    }

}