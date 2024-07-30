import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSumNoRepeat {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            //一级剪枝+一级去重
            //if(nums[i] > target && (nums[i]>=0 || target>0)) return res;
            if(nums[i] > 0  && nums[i] > target) return res;
            if(i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                //二级剪枝+二级去重
                //if(nums[i]+nums[j] > target && (nums[i]+nums[j]>=0 || target>0)) return res;
                if(nums[i]+nums[j] > 0 && nums[i]+nums[j] > target) continue;
                //因为后面要比较j-1,所以要保证j > i+1
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum<target){
                        left++;
                    }else if(sum>target){
                        right--;
                    }else{
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

}
class fourSumNoRepeatTest {
    public static void main(String[] args) {
        fourSumNoRepeat t = new fourSumNoRepeat();
        int[] ints = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> res = t.fourSum(ints,target);

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
