
public class aaTest {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3,7};
        int target = 1000;
//        System.out.println(serchInsertPosition.solution0(nums,5));
//        System.out.println(serchInsertPosition.solution0(nums,2));
//        System.out.println(serchInsertPosition.solution0(nums,7));
//        System.out.println(serchInsertPosition.solutionB(nums,5));
//        System.out.println(serchInsertPosition.solutionB(nums,2));
//        System.out.println(serchInsertPosition.solutionB(nums,7));
//            System.out.println(FindElementPosition.searchRange(nums,target)[0]);
//            System.out.println(FindElementPosition.searchRange(nums,target)[1]);
        //System.out.println(binarySearch.searchB(nums,target));
//        int[] array = squaresOfArray.sortedSquares(nums);
//        System.out.print("[");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]+", ");
//        }
//        System.out.println("]");

        //System.out.println(minimumSize.minSubArrayLen(target,nums));

        int[][] array = spiralMatrix.generateMatrix(5);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                //System.out.print("i:" + i+" j:" + j + " no: " + array[i][j]+" ");
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }

        }


}
