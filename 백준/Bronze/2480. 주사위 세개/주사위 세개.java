import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt(), n2=sc.nextInt(), n3=sc.nextInt();
        if(n1 == n2 && n2 == n3) System.out.print(1000*n1+10000);
        else if(n1==n2 || n1==n3 || n2==n3) System.out.print(100* (n1 == n2 || n1 == n3 ? n1 : n3)+1000);
        else System.out.print( (Math.max((Math.max(n2, n3)), n1)) * 100 );
    }
}