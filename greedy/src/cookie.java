import java.util.Arrays;

public class cookie {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length-1;
        int result = 0;
        for (int i = g.length-1; i >= 0; i--) {
            if(index >= 0 && s[index] >= g[i]){
                result++;
                index--;
            }
        }
        return result;
    }
}
class cookieTest {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        cookie example = new cookie();
        System.out.println(example.findContentChildren(g,s));
    }
}