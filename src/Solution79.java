public class Solution79 {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        if (board.length == 0 || board[0].length == 0) return false;
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; //左上下右
        boolean[][] beUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = check(0,word,i,j,board,direction,beUsed);
                if (res) return true;
            }
        }
        return res;
    }
    boolean inArea(int x,int y,char[][] board){
        if (x>=0 && x<board.length && y>=0 && y<board[0].length)
            return true;
        else
            return false;
    }
    private boolean check(int pos_word,String word,int x,int y,char[][] board,int[][] direction,boolean[][] beUsed){
        if (pos_word == word.length() - 1)
            return word.charAt(pos_word) == board[x][y];
        if (word.charAt(pos_word) == board[x][y]){
            beUsed[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int x_new = x + direction[i][0];
                int y_new = y + direction[i][1];
                if (inArea(x_new,y_new,board) && !beUsed[x_new][y_new]){
                    if (check(pos_word+1, word, x_new, y_new, board, direction,beUsed))
                        return true;
                }
            }
            beUsed[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        int[][] ints = {{}};
        String target = "ABCCED";
        System.out.println(new Solution79().exist(chars,target));
        System.out.println(ints.length + " " + ints[0].length);
    }
}
