public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n<2) return;
        int row=0,col=0;
        for (int i = 0; i < n/2; i++) { //多少圈
            for (int j = i; j < n-1-i; j++) { //每一圈往里缩小，头缩小，尾也缩小
                row = i;col=j;
                int tmp=matrix[row][col];
                for (int k = 0; k < 4; k++) {
                    int last = matrix[col][n-1-row],row_old=row;
                    matrix[col][n-1-row]=tmp;
                    //System.out.println(row+" "+col);
                    tmp = last;
                    row = col;col = n-1-row_old;

                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j <a.length ; j++) {
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
        new Solution48().rotate(a);
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j <a.length ; j++) {
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }

    }
}
