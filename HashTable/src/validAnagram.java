public class validAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;//记录s中每个元素出现的频次
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)-'a']--;//记录t中每个元素出现的频次，如果这个元素和s中的元素一致，则相抵
        }
        for (int i = 0; i < hash.length; i++) {
            //如果hash[]中每个元素都是0，即相等。
            if (hash[i] != 0) return false;
        }
        return true;
    }
    //10.11review
    public static boolean isAnagram01(String s, String t) {
        char[] hash = new char[26];
        if(s.length() != t.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)-'a'] --;
        }

        for (int i = 0; i < hash.length; i++) {
            if(hash[i] != 0){
                return false;
            }
        }
        return true;
    }

}
class validAnagramTest{
    public static void main(String[] args) {
        System.out.println(validAnagram.isAnagram01("anagram","nagaram"));
    }
}
