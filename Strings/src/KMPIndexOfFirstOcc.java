public class KMPIndexOfFirstOcc {
    public int strStr(String haystack, String needle) {
        //特殊情况：needle为""
        if(needle.length() == 0) return 0;

        int[] next = new int[needle.length()];
        int j = 0;
        getNext(next,needle);
        for (int i = 0; i < haystack.length(); i++) {
            //If the string and pattern string are not equal, then j=next[j-1], until j=0
            while(j>0 && haystack.charAt(i) != needle.charAt(j)) j = next[j-1];
            if(haystack.charAt(i) == needle.charAt(j)) j++;
            if(j == needle.length()) return i-needle.length()+1;
        }
        return -1;
    }
    public void getNext(int[] next, String needle){
        //initialize
        int j = 0;
        next[0] = j;
        for (int i = 1; i < needle.length(); i++) {
            //When the prefixes and suffixes are not equal, j=next [j-1] until j=0
            while(j>0 && needle.charAt(i) != needle.charAt(j)) j = next[j-1];
            if(needle.charAt(i) == needle.charAt(j)) j++;
            next[i] = j;
        }
    }
}
class KMPIndexOfFirstOccTest {
    public static void main(String[] args) {
        KMPIndexOfFirstOcc kmp = new KMPIndexOfFirstOcc();
        System.out.println(kmp.strStr("aabaabaaf","aabaaf"));
        System.out.println(kmp.strStr("aabaabaaf",""));
        System.out.println(kmp.strStr("sadbutsad","sad"));
        System.out.println(kmp.strStr("leetcode","leeto"));
    }
}
