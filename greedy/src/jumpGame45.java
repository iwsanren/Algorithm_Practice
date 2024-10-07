public class jumpGame45 {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;

        int cur = 0;//当前可到达范围
        int next = 0;//下次跳跃可到达范围
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            //取最大范围
            next = Math.max(next,i + nums[i]);
            if(i == cur){//到达现有范围边界了
                if(cur != nums.length-1){
                    cur = next;
                    result++;
                    if(cur >= nums.length-1) break;//如果超出边界，退出
                }
            }
        }
        return result;
    }
}
class jumpGame45Test {
    public static void main(String[] args) {
        jumpGame45 example = new jumpGame45();
        int[] nums = {2,3,0,1,4};
        System.out.println(example.jump(nums));
    }
}