public class squaresOfArray {
    public static int[] sortedSquares(int[] nums) {
        int[] sortSqArr = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int pointer = nums.length-1;
        while(left <= right){
            if(nums[left]*nums[left] < nums[right]*nums[right]){
                sortSqArr[pointer--] = nums[right]*nums[right];
                right--;
            }else{
                sortSqArr[pointer--] = nums[left]*nums[left];
                left++;
            }
        }
        return sortSqArr;
    }
    //9.19 review
    public int[] sortedSquares2(int[] nums) {
        int[] res = new int[nums.length];

        int left = 0;
        int right = nums.length-1;
        int pointer = right;//用于指向结果存放位置

        while(left <= right){
            if( Math.abs(nums[left]) < Math.abs(nums[right])){
                res[pointer] = nums[right] * nums[right];
                right--;
            }else{
                res[pointer] = nums[left] * nums[left];
                left++;
            }
            pointer--;
        }
        return res;
    }





















}
