public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;//当前节点油耗情况
        int totalSum = 0;//总油耗情况
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            //当前节点加油量不足以支撑车走到这个节点
            if(curSum < 0){
                //重新计算油箱剩余油量
                curSum = 0;
                //从当前节点的后一个再开始计算
                start = i + 1;
            }
        }
        if(totalSum < 0) return -1;
        return start;
    }
}
class gasStationTest {
    public static void main(String[] args) {

    }
}