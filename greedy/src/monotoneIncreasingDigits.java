public class monotoneIncreasingDigits {
    public monotoneIncreasingDigits() {    }
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();

        //用于记录末尾的9从哪里开始
        int start = chars.length;

        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i-1] > chars[i]){
                chars[i-1]--;
                start = i;
            }
        }

//        for (int i = chars.length - 2; i >= 0; i--) {
//            if(chars[i+1] < chars[i]){
//                chars[i]--;
//                start = i + 1;
//            }
//        }

//        System.out.println("start: " + start);

        for (int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(new String(chars));
    }
}
class monotoneIncreasingDigitsTest {
    public static void main(String[] args) {
        monotoneIncreasingDigits example = new monotoneIncreasingDigits();
        System.out.println(example.monotoneIncreasingDigits(3452331));
    }
}
