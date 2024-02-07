import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var set = new HashSet<Integer>(); int[] numArr = new int[3];
        int same = 0, maxNum = Integer.MIN_VALUE;
        for(int i=0; i<3; i++){
            numArr[i] = sc.nextInt();
            if(set.contains(numArr[i])) same = numArr[i];
            if(maxNum < numArr[i]) maxNum = numArr[i];
            set.add(numArr[i]);
        }
        if(set.size() == 1) System.out.println(10000+1000*same);
        else if(set.size() == 2) System.out.println(1000+100*same);
        else System.out.println(100*maxNum);
    }
}
