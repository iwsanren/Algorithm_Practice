import java.util.Arrays;

public class burstBalloon {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) ->  Integer.compare(a[0],b[0]) );
        //a[0]-b[0]
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            //当前气球的左边界小于等于上一个气球的右边界,则重叠
            if(points[i][0] <= points[i-1][1]){
                //将当前气球的右边界更新为当前气球和前一个气球右边界的最小值
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }else{
                result++;
            }
        }
        return result;
    }
}
class burstBalloonTest {
    public static void main(String[] args) {
        burstBalloon example = new burstBalloon();
        int[][] point = {
                //{10,16},{2,8},{1,6},{7,12}
                //{1,8},{3,4},{5,6},{7,8}
                {-2147483646,-2147483645},{2147483646,2147483647}
        };
        System.out.println(example.findMinArrowShots(point));
    }
}