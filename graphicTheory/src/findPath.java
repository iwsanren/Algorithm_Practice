import java.util.*;

public class findPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // nodes
        int m = sc.nextInt(); // sides

        disJoint disJoint = new disJoint(n + 1);//节点编号从1 - n

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            disJoint.join(u,v);
        }

        //get two integers in the last line, which represent source node and destination node respectively
        //use method isSame to determine whether they're in the same join
        if(disJoint.isSame(sc.nextInt(), sc.nextInt())){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }

}
