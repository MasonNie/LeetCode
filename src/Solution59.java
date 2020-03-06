public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int now = 1;
        int c1 = 0,c2 = n-1;
        int r1 = 0,r2 = n-1;
        while (now<=n*n && c1<=c2 && r1<=r2){
            for (int c = c1; c <= c2; c++) { //横
                res[r1][c] = now;
                now += 1;
            }
            for (int r = r1+1; r <= r2; r++) { //竖
                res[r][r2] = now;
                now += 1;
            }
            if (c1<c2 && r1<r2) { //确保四边形
                for (int c = c2-1; c > c1; c--) { //横
                    res[r2][c] = now;
                    now += 1;
                }
                for (int r = r2; r > r1; r--) { //竖
                    res[r][c1] = now;
                    now += 1;
                }
            }
            c1 += 1;
            c2 -= 1;
            r1 += 1;
            r2 -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] out = new Solution59().generateMatrix(0);
        for (int i = 0; i < out.length; i++) {
            for (int j = 0; j < out[0].length; j++) {
                System.out.print(out[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
