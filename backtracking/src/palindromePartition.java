import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class palindromePartition {
    List<List<String>> result = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }
    private void backtracking(String s, int startIndex){
        //System.out.println("Entering partitioning with startIndex = " + startIndex + " path = " + path);
        if(startIndex == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if(isPalindrome(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
            }else{
                continue;
            }
            backtracking(s,i+1);
            //System.out.println("In the for cycle with i = " + i + " path.last = " + path.getLast() + " startIndex= " + startIndex);
            path.removeLast();
        }
        //System.out.println("End partitioning with startIndex = " + startIndex + " path = " + path);
    }
    private boolean isPalindrome(String s, int start, int end){
        while(end > start){
            if(s.charAt(end) != s.charAt(start)) return false;
            end--;
            start++;
        }
        return true;
    }
}
class palindromePartitionTest {
    public static void main(String[] args) {
        palindromePartition example = new palindromePartition();
        List<List<String>> result = example.partition("aab");
        for(List<String> levels :result){
            System.out.print("[");
            for(String s : levels){
                System.out.print(s+" ");
            }
            System.out.println("]");
        }

    }
}