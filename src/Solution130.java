public class Solution130 {
    public void solve(char[][] board) {
        if (board.length<=1||board[0].length<=1) return;
        int m = board.length,n = board[0].length;
        for (int j = 0; j < n; j++) { //第一行
            if (board[0][j] == 'O') {
                //board[0][j] = '.';
                dfs(board,0,j);
            }
        }
        for (int i = 1; i < m; i++) { //第一列
            if (board[i][0] == 'O') {
                //board[i][0] = '.';
                dfs(board,i,0);
            }
        }
        for (int j = 1; j < n; j++) { //最后一行
            if (board[m-1][j] == 'O') {
                //board[m-1][j] = '.';
                dfs(board,m-1,j);
            }
        }
        for (int i = 1; i < m-1; i++) { //最后一列
            if (board[i][n-1] == 'O') {
                //board[i][n-1] = '.';
                dfs(board,i,n-1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '.') board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i==board.length||j==board[0].length||i<0||j<0){
            return;
        }
        if (board[i][j] == 'X' || board[i][j] == '.') return;
        if (board[i][j] == 'O') board[i][j] = '.';

        dfs(board, i+1, j); //上
        dfs(board, i-1, j);//下
        dfs(board, i, j-1);//左
        dfs(board, i, j+1);//右
    }

    public static void main(String[] args) {
        char[][] in = {
                {'X' ,'X', 'X', 'X'},
                {'X' ,'O', 'O', 'X'},
                {'X' ,'X', 'O', 'X'},
                {'X' ,'O', 'O', 'X' }
        };
        new Solution130().solve(in);
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[0].length; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }
        synchronized (in){

        }
    }
}
