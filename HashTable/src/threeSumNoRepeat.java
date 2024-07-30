import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class threeSumNoRepeat {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if(nums[i] > 0) return res;
            //对nums[i]去重
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                //先返回一个结果
                int sum = nums[i]  + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //这后面是得到一个结果后做的操作：去重left，去重right，left、right往前进一步
                    //再去重left right
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    //去重结束以后往下走!!!这步不能忘
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
class threeSumNoRepeatTest {
    public static void main(String[] args) {
        threeSumNoRepeat t = new threeSumNoRepeat();
        int[] ints = {-1,-1,1,0};
        List<List<Integer>> res = t.threeSum(ints);

        //遍历方法1：增强for循环
        for (List<Integer> innerList : res) {
            System.out.print("[");
            for (Integer num : innerList) {
                System.out.print(num + (innerList.indexOf(num) < innerList.size() - 1 ? ", " : ""));
            }
            System.out.println("]");
        }
        //遍历方法2：iterator
//        Iterator<List<Integer>> outerIterator = res.iterator();
//        while (outerIterator.hasNext()) {
//            List<Integer> innerList = outerIterator.next();
//            Iterator<Integer> innerIterator = innerList.iterator();
//
//            System.out.print("[");
//            while (innerIterator.hasNext()) {
//                Integer num = innerIterator.next();
//                System.out.print(num + (innerIterator.hasNext() ? ", " : ""));
//            }
//            System.out.println("]");
//        }
    }

}
//数组排序：Arrays.sort(arr);


