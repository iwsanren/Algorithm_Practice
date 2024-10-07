import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[27];
        //统计最远出现第i个字母的index
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a'] = i;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            //不断更新右边界
            right = Math.max(right,hash[s.charAt(i)-'a']);
            //遍历到了一组的最右位置
            if(right == i){
                result.add(right - left + 1);
                //左边界从下一组的第一个开始
                left = i+1;
            }
        }
        return result;
    }
}
class partitionLabelsTest {
    public static void main(String[] args) {
        partitionLabels example = new partitionLabels();
        System.out.println(example.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(example.partitionLabels("eccbbbbdec"));
        System.out.println(example.partitionLabels("abcdefghijk"));
        System.out.println(example.partitionLabels(""));
    }
}