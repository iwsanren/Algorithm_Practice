import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;

        Map<Integer,Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target-nums[i];
            if(record.containsKey(temp)){
                res[1] = i;
                res[0] = record.get(temp);
                break;
            }
            record.put(nums[i],i);
        }
        return res;
    }
}
class twoSumTest{
    public static void main(String[] args) {
//        int[] res = twoSum.twoSum(new int[]{2,3,5,7,8},9);
//        System.out.println(res[0]);
//        System.out.println(res[1]);

    }
}
//本题其实有四个重点：
//为什么会想到用哈希表
//哈希表为什么用map
//本题map是用来存什么的
//map中的key和value用来存什么的