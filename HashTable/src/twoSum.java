import java.util.HashMap;
import java.util.Map;

public class twoSum {
//    public int[] twoSum(int[] nums, int target) {
//        int[] res = new int[2];
//        if(nums == null || nums.length == 0) return res;
//
//        Map<Integer,Integer> record = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int temp = target-nums[i];
//            if(record.containsKey(temp)){
//                res[1] = i;
//                res[0] = record.get(temp);
//                break;
//            }
//            record.put(nums[i],i);
//        }
//        return res;
//    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0) return result;

        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(hash.containsKey(temp)){
                result[0] = hash.get(temp);
                result[1] = i;
            }
            hash.put(nums[i],i);//要放在判断后，不然会重复使用某个=target/2的元素。
        }
        return result;
    }

}
class twoSumTest{
    public static void main(String[] args) {
        int[] res = twoSum.twoSum(new int[]{3,2,4},6);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
//本题其实有四个重点：
//为什么会想到用哈希表
//哈希表为什么用map
//本题map是用来存什么的
//map中的key和value用来存什么的