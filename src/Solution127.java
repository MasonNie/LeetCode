import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        boolean[] used = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int res = 0;
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String seed = queue.poll();
                for (int j=0;j<wordList.size();j++) {
                    if (!used[j]){
                        if (vaild(seed,wordList.get(j))){
                            if (wordList.get(j).equals(endWord)) return res+1;
                            used[j] = true;
                            queue.offer(wordList.get(j));
                        }
                    }
                }
            }
        }
        return 0;
    }


    private boolean vaild(String beginWord, String endWord) {
        int flag = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i)!=endWord.charAt(i)) flag++;
            if (flag>1) return false;
        }
        return flag == 1;
    }

    public static void main(String[] args) {

        System.out.println(new Solution127().ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
