//Joint function class

public class disJoint{
    private int[] father;
    //initialization
    public disJoint(int n){
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int find(int n){
        if(n == father[n]){
            return n;
        }else{
            father[n] = find(father[n]);
            return father[n];
        }
    }

    public void join(int n, int m){
        n = find(n);
        m = find(m);
        if(n == m) return;
        father[m] = n;
    }

    public boolean isSame(int n, int m){
        n = find(n);
        m = find(m);
        return n == m;
    }

}
