import java.util.Scanner;

public class redundantConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        disJoint disJoint = new disJoint(n + 1);

        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            //this two point have already been in one set
            if(disJoint.isSame(u,v)){
                System.out.println(u + " " + v);
                break;
            }else{
                disJoint.join(u,v);
            }
        }
    }
}
