import java.util.Arrays;

public class candy {
    public candy(){};
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        //从左到右遍历，如果右边的孩子比左边的孩子得分高，则让右边的孩子多吃一块糖
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = (ratings[i] > ratings[i-1]) ? candies[i-1] + 1 : 1;
        }
        //从右向左遍历
        for (int i = ratings.length-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i+1]+1,candies[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        Arrays.stream(candies).sum();
        return sum;
    }
}
class candyTest {
    public static void main(String[] args) {
        candy example = new candy();
        int[] rating = {1,2,2,1,3,2};
        System.out.println(example.candy(rating));
    }
}

//            if(ratings[i] > ratings[i-1]){
//                candies[i] = candies[i-1] + 1;
//                //否则就只有一块糖
//            }else{
//                candies[i] = 1;
//            }