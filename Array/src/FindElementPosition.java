public class FindElementPosition {
//    public static int[] searchRange(int[] nums, int target) {
//        int leftBoarder = getLeftBoarder(nums,target);
//        int rightBoarder = getRightBoarder(nums,target);
//        if((leftBoarder == -2 && rightBoarder == -2) || rightBoarder-leftBoarder < 0){
//            return new int[]{-1,-1};
//        }
//        return new int[]{leftBoarder, rightBoarder};
//    }
//    static int getLeftBoarder(int[] nums, int target){
//        int left = 0;
//        int right = nums.length-1;// 注意这里应该是length-1，避免数组越界
//        int leftBoarder = -2;
//        while(left <= right){
//            int middle = left + ((right-left)/2);
//            if(nums[middle] == target){
//                leftBoarder = middle;// 找到目标值，更新左边界
//                right = middle-1;// 继续向左搜索，看是否有更左边的目标值
//            }else if(nums[middle] < target){
//                left = middle+1;
//            }else{
//                right = middle-1;
//            }
//        }
//        return leftBoarder;
//    }
//    static int getRightBoarder(int[] nums, int target){
//        int left = 0;
//        int right = nums.length-1;
//        int rightBoarder = -2;
//        while(left <= right){
//            int middle = left + ((right-left)/2);
//            if(nums[middle] == target){
//                rightBoarder = middle;//找到目标值，更新右边界
//                left = middle+1;//继续向右检索，看是否有更右边的目标值
//            }else if(nums[middle] < target){
//                left = middle+1;
//            }else{
//                right = middle-1;
//            }
//        }
//        return rightBoarder;
//    }
int[] searchRange(int[] nums, int target) {
    int leftBorder = getLeftBorder(nums, target);
    int rightBorder = getRightBorder(nums, target);
    // 情况一
    if (leftBorder == -2 || rightBorder == -2) {
        System.out.println("a");
        System.out.println("leftBorder: " + getLeftBorder(nums, target) +"; rightBorder: "+getRightBorder(nums, target));
        return new int[]{-1, -1};
    }
    // 情况三
    if (rightBorder - leftBorder > 1) {
        System.out.println("b");
        System.out.println("leftBorder: " + getLeftBorder(nums, target) +"; rightBorder: "+getRightBorder(nums, target));
        return new int[]{leftBorder + 1, rightBorder - 1};
    }
    // 情况二
    System.out.println("c");
    System.out.println("leftBorder: " + getLeftBorder(nums, target) +"; rightBorder: "+getRightBorder(nums, target));
    return new int[]{-1, -1};
}

    int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录一下rightBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle - 1;
            } else { // 寻找右边界，nums[middle] == target的时候更新left
                left = middle + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录一下leftBorder没有被赋值的情况
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 寻找左边界，nums[middle] == target的时候更新right
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,7,8,8,10,11,14,17,17,17,21};
        int target = 16;
        FindElementPosition fep = new FindElementPosition();
        System.out.println(fep.searchRange(nums,target)[0]);
        System.out.println(fep.searchRange(nums,target)[1]);
    }
}
