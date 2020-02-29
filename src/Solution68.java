import java.util.LinkedList;
import java.util.List;

public class Solution68 {
    /***
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Text Justification.
     * Memory Usage: 38.1 MB, less than 5.55% of Java online submissions for Text Justification.
     * @param words 单词列表
     * @param maxWidth 最大长度
     * @return 断句之后的结果
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        if (words.length == 0) return res;
        int start = 0,end = 0,count = 0;
        for (int i = 0; i < words.length; i++) {
            count += words[i].length();
            if (count > maxWidth){
                end = i - 1;
                count = count - words[i].length() - 1;
                justifyLen(start,end,count,res,words,maxWidth);
                start = end + 1;
                count = 0;
                i--;
            }
            else if (count == maxWidth){
                end = i;
                justifyLen(start,end,count,res,words,maxWidth);
                start = end + 1;
                count = 0;
            }else {
                if (i < words.length - 1)
                    count++;
                else{
                    // 最后一行特殊处理
                    StringBuilder lastLine = new StringBuilder();
                    for (int j = start; j <= i; j++) {
                        lastLine.append(words[j]);
                        lastLine.append(" ");
                    }
                   while (maxWidth != lastLine.length()){
                        lastLine.append(" ");
                    }
                    res.add(lastLine.toString());
                }

            }
        }
        return res;
    }
    private void justifyLen(int start,int end,int count,List<String> res,String[] words,int maxWidth) {
        StringBuilder line = new StringBuilder();
        if (end == start) {
            line.append(words[start]);
            for (int i = 0; i < maxWidth - count; i++) {
                line.append(" ");
            }
            res.add(line.toString());
            return;
        }
        if (count == maxWidth){
            for (int i = start; i <= end; i++) {
                line.append(words[i]);
                if (i < end) {
                    line.append(" ");
                }
            }
            res.add(line.toString());
            return;
        }
        //多个空格
        int out = maxWidth - count + (end - start); //需要多少个空格
        int yuShu = out%(end - start),other = out / (end - start);
        //if (yuShu == 0) yuShu = other;
        for (int i = start; i <= end; i++) {
            line.append(words[i]);
            if (yuShu > 0) {
                line.append(" ");
                yuShu--;
            }
            if (i < end){
                for (int j = 0; j < other; j++)
                        line.append(" ");
            }
        }
        res.add(line.toString());
        return;
    }

    public static void main(String[] args) {
        String[] a = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] b = {"What","must","be","acknowledgment","shall","be"};
        String[] c = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        String[] in = c;
        int maxWidth = 20;
        List<String> out = new Solution68().fullJustify(in,maxWidth);
        for (String line:out
             ) {
            System.out.println(line + " " + line.length());
        }


    }
}
