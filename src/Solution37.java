public class Solution37 {
    public void solveSudoku(char[][] board) {
        boolean[][] rowStat = new boolean[9][10];
        boolean[][] colStat = new boolean[9][10];
        boolean[][][] gridStat = new boolean[3][3][10];

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //
                if ('0'<board[i][j]&&board[i][j]<='9'){
                    int num = board[i][j]- '0';
                    rowStat[i][num] = true;
                    colStat[j][num] = true;
                    gridStat[i/3][j/3][num] = true;
                }
            }
        }

        backtrack(board,rowStat,colStat,gridStat,0,0);

    }
    boolean backtrack(char[][] board,boolean[][] rowStat,boolean[][] colStat,boolean[][][] gridStat,int row,int col){
        if (col==board[0].length){
            if (row==board.length) return true;
            else {
                col = 0;
                row +=1;
            }
        }
        if (board[row][col] == '.') {
            for (int num = 1; num < 10; num++) {
                boolean cantUse = rowStat[row][num] || colStat[col][num] || gridStat[row/3][col/3][num];
                if (!cantUse){
                    rowStat[row][num] = true;
                    colStat[col][num] = true;
                    gridStat[row/3][col/3][num] = true;
                    board[row][col] = (char)('0' + num);
                    if (backtrack(board, rowStat, colStat, gridStat, row, col+1)){
                        return true;
                    }
                    else {
                        rowStat[row][num] = false;
                        colStat[col][num] = false;
                        gridStat[row/3][col/3][num] = false;
                        board[row][col] = '.';
                    }
                }
            }
        }
        else {
            return backtrack(board, rowStat, colStat, gridStat, row, col+1);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
