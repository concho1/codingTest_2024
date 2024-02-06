import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputH = sc.nextInt();
        int inputM = sc.nextInt();

        int time = inputH*60 + inputM;
        time -= 45;
        if(time < 0) time += 24*60;
        int h = time/60;
        int m = time%60;
        System.out.println(h);
        System.out.println(m);
    }
}