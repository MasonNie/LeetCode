public class Solution71 {
    /**
     *Runtime: 6 ms, faster than 49.73% of Java online submissions for Simplify Path.
     * Memory Usage: 40.1 MB, less than 6.67% of Java online submissions for Simplify Path.
     * @param path
     * @return
     */

    public String simplifyPath(String path) {
        StringBuilder tmp_path = new StringBuilder(path);
        int pos = 0;
        while (pos < tmp_path.length()){
            if (pos>0&&tmp_path.charAt(pos)=='/'){
                if (tmp_path.charAt(pos-1)=='/')
                    tmp_path.deleteCharAt(pos);
                else //正常的一个/
                    pos++;
            }
            else if (pos>0&&tmp_path.charAt(pos)=='.'){
                int count_dot = 1;
                pos = pos+1;
                while (pos<tmp_path.length()&&tmp_path.charAt(pos)=='.'){
                    count_dot++;
                    pos++;
                }
                //删除../返回上一层目录
                if (count_dot==2&&(pos==tmp_path.length()||tmp_path.charAt(pos)=='/')){
                    int pos_start = pos-1,count_gang = 0;
                    while (count_gang < 2){
                        if (tmp_path.charAt(pos_start)=='/')
                            count_gang++;
                        if (pos_start == 0||count_gang==2) break;
                        else pos_start--;
                    }
                    tmp_path.delete(pos_start,pos);
                    pos = pos_start;
                }else if (count_dot==1){
                    if (pos == tmp_path.length()){
                        tmp_path.deleteCharAt(tmp_path.length()-1);
                    }else if (tmp_path.charAt(pos)=='/'){
                        //只有一个. 表示./本目录直接删除
                        tmp_path.deleteCharAt(pos-1);
                        pos--;
                    }
                }

            }
            else {
                pos++;
            }
        }
        if (tmp_path.length()>1&&tmp_path.charAt(tmp_path.length()-1)=='/')
            tmp_path.deleteCharAt(tmp_path.length()-1);
        if (tmp_path.length()==0) return "/";
        return tmp_path.toString();
    }

    public static void main(String[] args) {
        String in = "/a/../../b/../c//.//.";
        System.out.println(new Solution71().simplifyPath(in));
    }
}
