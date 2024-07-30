import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class frequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        //建立一个HashMap,key用于存放数字，value用于存放出现的频率
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        //建立一个PriorityQueue，用小顶堆的思路建立（优先弹出最小值）
        PriorityQueue<int[]> dq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            //当dq内元素数量小于k时，则直接加入
            if(dq.size() < k){
                dq.add(new int[]{entry.getKey(),entry.getValue()});
            //反之则要作比较。当元素比dq中的最小值大时，则要将原最小值弹出，再填入新的最小值。
            }else if(entry.getValue() > dq.peek()[1]){
                dq.poll();
                dq.add(new int[]{entry.getKey(),entry.getValue()});
            }
        }
        //建立一个长度为k的数组。由于dq会先弹出最小值，所以数组的填充要从后向前填。
        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = dq.poll()[0];
        }
        return res;
    }
}
class frequentElementsTest {
    public static void main(String[] args) {
        frequentElements fe = new frequentElements();
        int[] arr = {3,2,1,4,4,1,1,4,4,5,7,7};
        int[] res = fe.topKFrequent(arr,2);
        System.out.print("[");
        for(int i : res){
            System.out.print(i + " ");
        }
        System.out.print("]");

    }
}