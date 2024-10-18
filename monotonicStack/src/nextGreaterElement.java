import java.util.*;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        //solution1: without stack
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//
//        int[] result = new int[len1];
//        //先给result赋值-1，如果没有被覆盖过就是找不到对应的值
//        Arrays.fill(result,-1);
//
//        int num = 0;
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                if(nums1[i] == nums2[j]){
//                    num = nums1[i];
//                    for (int k = j+1; k < len2; k++) {
//                        if(nums2[k] > num){
//                            result[i] = nums2[k];
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return result;
        //solution2: use stack
        int len1 = nums1.length;
        int len2 = nums2.length;

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[len1];
        if (len1 == 0) {
            return result;
        }

        Arrays.fill(result, -1);
        //用于查找元素在nums1中是否存在
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], i);
        }
        stack.push(0);
        for (int i = 1; i < len2; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    if (map.containsKey(nums2[stack.peek()])) {//查找该元素在nums1中是否存在
                        result[map.get(nums2[stack.peek()])] = nums2[i]; //存在才存入
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}

class nextGreaterElementTest {
    public static void main(String[] args) {
        nextGreaterElement example = new nextGreaterElement();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.out.println(Arrays.toString(example.nextGreaterElement(nums1, nums2)));
    }
}