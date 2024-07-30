public class reverseWord {
    //方法1：使用StringBuilder 去除多余空格以后反转每一个单词
    public String reverseWords(String s) {
        //去除多余空格
        StringBuilder sb = removeSpace(s);
        sb = reverseString(sb,0,sb.length()-1);
        sb = eachWord(sb);
        return sb.toString();
    }
    public StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length()-1;
        //去除开头结尾的所有空格
        while(s.charAt(start) == ' ') start++;
        while(s.charAt(end) == ' ') end--;
        //去除中间的多余空格
        StringBuilder sb = new StringBuilder();
        while(start <= end){
            char c = s.charAt(start);
            //start遍历到的元素不为0/单词末尾可以存一个空格
            if(c != ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
    public StringBuilder reverseString(StringBuilder sb, int start, int end){
        while(start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
        return sb;
    }
    public StringBuilder eachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int n = sb.length();
        while(start < n){
            //从后往前判断。
            while(end < n && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb,start,end-1);
            start = end+1;
            end = start+1;
        }
        return sb;
    }

    public String reverseWords2(String s) {
        return s;
    }
    public String reverseWords3(String s) {
        return s;
    }

}
class reverseWordTest {
    public static void main(String[] args) {
        reverseWord rw = new reverseWord();
        System.out.println(rw.reverseWords("a good   example"));
    }

}