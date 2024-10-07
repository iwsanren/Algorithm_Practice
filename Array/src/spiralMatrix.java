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

    public int[][] generateMatrix2(int n) {
        int count = 1;
        int[][] res = new int[n][n];
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                res[i][j] = count++;
            }
            for (int j = i; j < n - i - 1; j++) {
                res[j][n - i - 1] = count++;
            }
            for (int j = n - i - 1; j > i; j--) {
                res[n - i - 1][j] = count++;
            }
            for (int j = n - i - 1; j > i; j--) {
                res[j][i] = count++;
            }
        }
        if(n % 2 != 0){
            res[n/2][n/2] = count;
        }
        return res;
    }
}
class spiralMatrixTest {
    public static void main(String[] args) {
        spiralMatrix example = new spiralMatrix();
        int[][] res = example.generateMatrix2(5);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}