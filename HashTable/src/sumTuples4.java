import java.util.HashMap;
import java.util.Map;

public class sumTuples4 {
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        int count = 0;
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i : nums1){
//            for(int j:nums2){
//                int sum = i+j;
//                map.put(sum,map.getOrDefault(sum,0)+1);
//            }
//        }
//        for(int i : nums3){
//            for(int j:nums4){
////                int sum = -(i+j);
////                if(map.containsKey(sum)){
////                    count += map.get(sum);
////                }
//                //可简化为：返回key=-（i+j)对应的value，如果没有，则返回0
//                count  += map.getOrDefault(0-(i+j),0);
//            }
//        }
//        return count;
//    }
//24.10.14 review
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> hash1 = new HashMap<>();
        //HashMap<sum of first two integers, times>
        for(int i: nums1){
            for(int j: nums2){
                int sum = i+j;
                hash1.put(sum,hash1.getOrDefault(sum,0)+1);
            }
        }
        int count = 0;
        for(int i: nums3){
            for(int j: nums4){
                int sum = i+j;
                //hash1.put(sum,hash1.getOrDefault(sum,0)+1);
                count += hash1.getOrDefault(-sum,0);
            }
        }
        return count;
    }
}
class sumTuples4Test{
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        sumTuples4 s = new sumTuples4();
        System.out.println(s.fourSumCount(nums1,nums2,nums3,nums4));
    }
}

//getOrderDefault(Object key,Integer default number):
//key：要检索的键。
//defaultValue：如果 Map 中不存在该键，则返回此默认值。

