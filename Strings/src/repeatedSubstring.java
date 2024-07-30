public class repeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        getNext(next,s);
        //最长相等前后缀不包含的部分就是重复子串.所以重复子串的长度就是字符串的长度-最长相等前后缀。且重读字符串的最长相等前后缀长度为next数组的最后一位。
        //所以：
        int len = next.length-next[next.length-1];
        //最后一位不为0，且字符串长度可以被重复子串长度整除
        if(next[s.length()-1]>0 && s.length()%len==0){
            return true;
        }
        return false;
    }

    public void getNext(int[] next, String s){
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
class repeatedSubstringTest {
    public static void main(String[] args) {
        repeatedSubstring rs  = new repeatedSubstring();
        System.out.println(rs.repeatedSubstringPattern("abaababaababaab"));
    }
}