import java.util.Arrays;
import java.util.LinkedList;

public class queueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        //sort people array via height in descend order firstly. if two people share the same height, I will sort them via k in ascend order.
        //sort(T[] a, Comparator<? super T> c)
        //Sorts the specified array of objects according to the order induced by the specified comparator.
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];}
        );

        LinkedList<int[]> result = new LinkedList<>();
        for(int[] p : people){
            //add(int index, E element): Inserts the specified element at the specified position in this list.
            result.add(p[1],p);
        }
        return result.toArray(new int[result.size()][]);
    }
}
class queueReconstructionTest {
    public static void main(String[] args) {

    }
}