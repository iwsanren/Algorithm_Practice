import java.util.*;

public class stringSequence {

    public static int bfs(String strStart, String strEnd, List<String> wordlist) {
        //used as query container, get more efficiency
        Set<String> set = new HashSet<>(wordlist);

        //store the string has been visited and its path
        Map<String, Integer> visited = new HashMap<>();

        //store the new string which is converted from the original one by change one char and is equal to a word in wordlist
        Queue<String> queue = new LinkedList<>();
        queue.add(strStart);
        visited.put(strStart,1);

        while (!queue.isEmpty()) {
            String curWord = queue.poll();
            int path = visited.get(curWord);

            for (int i = 0; i < curWord.length(); i++) {
                char[] ch = curWord.toCharArray();

                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;

                    String newWord = new String(ch);

                    if (newWord.equals(strEnd)) {
                        return path + 1;
                    }

                    //if this new word belongs to set and hasn't been visited
                    if (set.contains(newWord) && !visited.containsKey(newWord)) {
                        visited.put(newWord, path + 1);
                        //add to queue, for the next iteration
                        queue.add(newWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();

        String[] str_start_end = sc.nextLine().split(" ");

        List<String> wordList = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            wordList.add(sc.nextLine());
        }

        int result = bfs(str_start_end[0], str_start_end[1], wordList);
        System.out.println(result);
    }


}
