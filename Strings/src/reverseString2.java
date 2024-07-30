public class reverseString2 {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i += 2*k) {
            int start = i;
            int end = Math.min(c.length-1,start+k-1);
            while(start < end){
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }
        return new String(c);
    }

}
class reverseString2Test {
    public static void main(String[] args) {
        reverseString2 r = new reverseString2();
        String s = r.reverseStr("abcdefg",2);
        System.out.println(s);
    }
}
