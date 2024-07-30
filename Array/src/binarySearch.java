import java.util.Arrays;

public class binarySearch {
    public int search0(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static int searchB(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = (left + right)/2;
            if(nums[middle] > target){
                right = middle;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else return middle;
        }
        return -1;
    }
}

