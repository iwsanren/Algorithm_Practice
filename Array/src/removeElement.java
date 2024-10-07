public class removeElement {
    public int removeElement(int[] nums, int val) {
//        int k = nums.length;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] == val){
//                for (int j = i; j < nums.length; j++) {
//                    nums[j - 1] = nums[j];
//                }
//                i--;// 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
//                k--;
//            }
//        }
//        return k;

        //双指针解法
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    //9.19 review
    public int removeElement2(int[] nums, int val) {
        int slow = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }
        return slow;
    }
}
