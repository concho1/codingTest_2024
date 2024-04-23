import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] f = sc.nextLine().split(" ");

        int poNum = Integer.parseInt(f[0]);
        int qNum = Integer.parseInt(f[1]);
        var polist = new ArrayList<String>();
        var poMap = new HashMap<String, Integer>();
        polist.add("some");
        for(int i=0; i<poNum; i++){
            String str = sc.nextLine().trim();
            polist.add(str);
            poMap.put(str,i+1);
        }
        for(int i=0; i<qNum; i++){
            String str = sc.nextLine().trim();
            if(Character.isDigit(str.charAt(0))){
                System.out.println(polist.get(Integer.parseInt(str)));
            }else{
                System.out.println(poMap.get(str));
            }
            
        }
        sc.close();
    }
}