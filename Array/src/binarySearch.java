import java.util.Arrays;

public class binarySearch {
    public int search0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int searchB(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else return middle;
        }
        return -1;
    }

    //9.19 review
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        //此处是左闭右闭的写法，即左右边界的值都可以取到
        int left = 0;
        int right = nums.length - 1;
        int middle = left + (right - left) / 2;
        //那么左右边界就可以相等。之前错误写成了left < right，这导致了只有一个元素的时候无法进入此循环。
        while (left <= right) {
            if (target == nums[middle]) return middle;
            if (target > nums[middle]) {
                left = middle + 1;
                middle = left + (right - left) / 2;
            } else if (target < nums[middle]) {
                //这里也同样要注意，右边界可以取到了，不可以让它等于middle
                right = middle - 1;
                middle = left + (right - left) / 2;
            }
        }
        return -1;
    }
}

