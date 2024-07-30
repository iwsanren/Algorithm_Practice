public class ransomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i)-'a']--;
        }
        for(int i : arr){
            if(i < 0) return false;
        }
        return true;
    }
}
class ransomNoteTest {
    public static void main(String[] args) {
        ransomNote r  = new ransomNote();
        System.out.println(r.canConstruct("a","b"));
        System.out.println(r.canConstruct("aa","ab"));
        System.out.println(r.canConstruct("aa","aab"));

    }
}