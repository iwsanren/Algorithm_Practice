import java.util.Arrays;

public class nonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int result = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]){
                result++;
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            }else{
                continue;
            }
        }
        return result;
    }
    //按照右边界排序
    public int eraseOverlapIntervalsRight(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));

        int lapping = 0;

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]){
                lapping++;
                intervals[i][1] = intervals[i-1][1];
            }else{
                continue;
            }
        }
        return lapping;
    }
}
class nonOverlappingIntervalsTest {
    public static void main(String[] args) {
        nonOverlappingIntervals example = new nonOverlappingIntervals();
        int[][] intervals = {
                {1,2},{2,3},{3,4},{1,3}
        };
        System.out.println(example.eraseOverlapIntervals(intervals));
        System.out.println(example.eraseOverlapIntervalsRight(intervals));
    }
}