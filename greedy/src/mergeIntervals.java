import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= right){
                right = Math.max(intervals[i][1],right);
            }else{
                result.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        result.add(new int[]{left,right});
        return result.toArray(new int[result.size()][]);
    }
}
class mergeIntervalsTest {
    public static void main(String[] args) {
        mergeIntervals example = new mergeIntervals();
        int[][] intervals = {
                //{1,3},{2,6},{8,10},{15,18}
                {2,3},{4,5},{6,7},{8,9},{1,10}
                //{-2147483646,-2147483645},{2147483646,2147483647}
        };
        int[][] result = example.merge(intervals);
        for(int[] line : result){
            System.out.print("[ ");
            for(int i : line){
                System.out.print(i + " ,");
            }
            System.out.print(" ] ");
        }
    }
}
