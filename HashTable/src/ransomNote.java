import java.util.HashMap;

public class ransomNote {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        int[] arr = new int[26];
//        for (int i = 0; i < magazine.length(); i++) {
//            arr[magazine.charAt(i)-'a']++;
//        }
//        for (int i = 0; i < ransomNote.length(); i++) {
//            arr[ransomNote.charAt(i)-'a']--;
//        }
//        for(int i : arr){
//            if(i < 0) return false;
//        }
//        return true;
//    }
// 24.10.14 review
    public boolean canConstruct(String ransomNote, String magazine) {
        //本题和392不一样的地方是：392要求子序列和母序列顺序一致。

//        int len1 = ransomNote.length();
//        int len2 = magazine.length();
//
//        int[][] dp = new int[len1+1][len2+1];
//        int result = 0;
//
//        for (int i = 1; i <= len1; i++) {
//            for (int j = 1; j <= len2; j++) {
//                if(ransomNote.charAt(i-1) == magazine.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }else{
//                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
//                }
//                if(dp[i][j] > result){
//                    result = dp[i][j];
//                }
//            }
//        }
//        return result == len1;
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i)-'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                return false;
            }
        }
        return true;
    }
}
class ransomNoteTest {
    public static void main(String[] args) {
        ransomNote r  = new ransomNote();
        System.out.println(r.canConstruct("a","b"));
        System.out.println(r.canConstruct("aa","ab"));
        System.out.println(r.canConstruct("aa","aab"));

    }
}