import java.util.LinkedList;
import java.util.List;

public class combinationPhoneNum {
    List<String> result = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")||digits.length() == 0 || digits == null) return result;
        String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtracking(digits,letterMap,0);
        return result;
    }
    StringBuilder temp = new StringBuilder();
    //int num用于定位digits
    private void backtracking(String digits, String[] letterMap, int num){
        if(num == digits.length()){
            result.add(temp.toString());
            return;
        }
        String str = letterMap[digits.charAt(num)-'0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(digits,letterMap,num+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
class combinationPhoneNumTest {
    public static void main(String[] args) {
        combinationPhoneNum example = new combinationPhoneNum();
        List<String> result = example.letterCombinations("25");

        for(String s : result){
            System.out.println(s);
        }
    }
}