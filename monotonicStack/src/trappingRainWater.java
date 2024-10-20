import java.util.Stack;

public class trappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack();
        int sum = 0;// water be trapped

        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            //单调递增栈
            if(height[i] < height[stack.peek()]){
                stack.push(i);
            }else if(height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                    int mid = stack.pop();
                    if(!stack.isEmpty()){
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
class trappingRainWaterTest {
    public static void main(String[] args) {
        trappingRainWater example = new trappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(example.trap(height));
    }
}