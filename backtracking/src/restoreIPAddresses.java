import java.util.LinkedList;
import java.util.List;

public class restoreIPAddresses {
    List<String> result = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb,0,0);
        return result;
    }
    private void backtracking(StringBuilder sb, int startIndex, int pointSum){
        if(pointSum == 3){
            if(isValid(sb,startIndex,sb.length()-1)){
                result.add(sb.toString());
            }
            return;
        }
        for (int i = startIndex; i < sb.length(); i++) {
            if(isValid(sb,startIndex,i)){
                sb.insert(i+1,".");
                pointSum++;
            }else{
                break;//后面的不用再看了，直接退出
            }
            backtracking(sb,i+2,pointSum);
            sb.deleteCharAt(i+1);
            pointSum--;
        }
    }
    private boolean isValid(StringBuilder sb, int start, int end){
        if(end < start){
            return false;
        }
        //这里的0是char，所以要打上''！！！不然是不会return false的！
        if(sb.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = sb.charAt(i) - '0';
            num = num * 10 + digit;
            if(num > 255) return false;
        }
        return true;
    }
}
class restoreIPAddressesTest {
    public static void main(String[] args) {
        restoreIPAddresses example = new restoreIPAddresses();
        List<String> result = example.restoreIpAddresses("255012");
        for(String s : result){
            System.out.println(s);
        }
    }
}