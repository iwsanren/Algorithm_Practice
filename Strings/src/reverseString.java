public class reverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
class reverseStringTest {
    public static void main(String[] args) {
        reverseString r = new reverseString();
        char[] s = new char[5];
        s[0] = 'h';
        s[1] = 'e';
        s[2] = 'l';
        s[3] = 'l';
        s[4] = 'o';
        r.reverseString(s);
    }
}
