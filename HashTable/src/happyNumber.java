import java.util.HashSet;
import java.util.Set;

public class happyNumber {
    //    public boolean isHappy(int n) {
//        Set<Integer> res = new HashSet<>();
//        //当n！=1 且 res不包含n的时候继续求n各位平方和。一旦进入循环就退出。
//        while(n!=1 && !res.contains(n)){
//            res.add(n);
//            n = getSum(n);
//        }
//        //如果n==1，return true
//        return n==1;
//    }
//    //求出n各位的平方和
//    public int getSum(int n){
//        int sum = 0;
//        while (n > 0){
//            int temp = n % 10;
//            sum += temp * temp;
//            n = n/10;
//        }
//        return sum;
//    }
    //24.10.11 review
    public static boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<>();
        n = getSum(n);
        //当平方和不为1且hash中不包含n的时候继续循环
        while (n != 1 && !hash.contains(n)) {
            hash.add(n);
            //System.out.println("After getSum: " + n);
            n = getSum(n);
        }
        //System.out.println(n);
        return n == 1 ? true : false;

    }

    public static int getSum(int n) {
        int sum = 0;
        while(n != 0){
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }


}

class happyNumberTest {
    public static void main(String[] args) {
        System.out.println(happyNumber.isHappy(25));
    }

}