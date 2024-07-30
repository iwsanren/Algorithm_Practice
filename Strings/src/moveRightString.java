public class moveRightString {
    //简单版
    public String moveRightString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-k; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < s.length()-k; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    //反转字符串版
    public String moveRightString2(String s, int k) {
        char[] c = s.toCharArray();
        reverseChar(c,0,s.length()-k-1);
        reverseChar(c,s.length()-k,s.length()-1);
        reverseChar(c,0,s.length()-1);
        return new String(c);
    }
    public void reverseChar(char[] c,int start, int end){
        while(start < end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
            start++;
            end--;
        }
    }
}
class moveRightStringTest{
    public static void main(String[] args) {
        moveRightString mrs = new moveRightString();
        System.out.println(mrs.moveRightString2("abcdefg",2));
    }

}