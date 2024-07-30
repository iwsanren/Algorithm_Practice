public class spiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int offset = 1;
        int count = 1;//numbers recorded into matrix
        int loop = 1;//record the current loop number
        int i,j;

        while (loop <= n/2 ){
            for (j = starty; j < n-offset; j++) {
                res[startx][j] = count++;
            }
            for(i = startx; i < n-offset; i++){
                res[i][j] = count++;
            }
            for(;j > startx; j--){
                res[i][j] = count++;
            }
            for(;i > starty; i--){
                res[i][j] = count++;
            }
            startx++;
            starty++;
            loop++;
            offset++;
        }
        if(n%2 != 0) res[n/2][n/2] = count;
        return res;
    }
}
