import java.util.ArrayDeque;
import java.util.Deque;
class swmQueue{
    Deque<Integer> deuqe= new ArrayDeque();
    //当传入变量的值和队列第一个元素相等时才需要弹出。
    void poll(int var){
        if(!deuqe.isEmpty() && deuqe.peek() == var){
            deuqe.pollFirst();
        }
    }
    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //！！！入口对应deque的last！！！
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void offer(int var){
        //注意这里要用while，因为可能要弹出不止一个元素
        //当var和入口元素相等时，无需弹出！否则当传入两个最大值时，这一步会重复很多次，导致窗口范围内的最大值弹出。
        while(!deuqe.isEmpty() && var > deuqe.peekLast()){
            deuqe.pollLast();
        }
        deuqe.offerLast(var);

    }
    int peek(){
        return deuqe.peekFirst();
    }
}
public class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //剪枝
        if(nums.length == 1) return nums;

        int length = nums.length-k+1;
        int[] res = new int[length];
        int index = 0;
        swmQueue que = new swmQueue();

        //先把前k个元素都加入进去
        for (int i = 0; i < k; i++) {
            que.offer(nums[i]);
        }
        //存入第一个最大值
        res[index++] = que.peek();
        //再遍历剩下的元素
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除时判断该元素是否放入队列
            que.poll(nums[i-k]);
            //加入新元素
            que.offer(nums[i]);
            //把最大值存入数组
            res[index++] = que.peek();
        }
        return res;
    }
}

class slidingWindowMaxTest {
    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        slidingWindowMax slidingWindowMax = new slidingWindowMax();
        int[] res = slidingWindowMax.maxSlidingWindow(nums,4);
        System.out.print("[");
        for(int i:res){
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}
