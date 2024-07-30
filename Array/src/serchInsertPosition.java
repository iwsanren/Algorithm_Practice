public class serchInsertPosition {
    public static int solution0(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
    //二分法解法：自己写的
    public static int solutionB(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = (left+right)/2;
            if (nums[middle] < target){
                left = middle+1;
            }else if(nums[middle] > target) {
                if(nums[middle-1] < target){
                    return middle;
                }else{
                    right = middle;
                }
            }else return middle;
        }
        return nums.length;
    }
    //answer1：
    public static int solutionB1(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int middle = left + (right-left)/2;//avoid Integer overflow
            if(nums[middle] < target){
                left = middle+1;//find righter side
            }else if(nums[middle] > target){
                right = middle-1;
            }else{
                return middle;
            }
        }
        /*solve four situations individually:
        1.target is equal to one element : return middle;
        2.target is lesser than every element [0,-1] : right = middle - 1; right = -1 ; return right+1;
        3.target is inserted into the middle position of the array: [left, right]，return  right + 1
        4.target is larger than every element:[left, right]， because the boarder is closed to right，so return right + 1
        */
        return right+1;
    }
}

