import java.util.*;
class Solution {
    public int solution(String s) {
        /*
        var transMap = new HashMap<String,Character>();
        var numSet = new HashSet<Character>();
        transMap.put("zero",'0');   numSet.add('0');
        transMap.put("one", '1');   numSet.add('1');
        transMap.put("two", '2');   numSet.add('2');
        transMap.put("three", '3'); numSet.add('3');
        transMap.put("four", '4');  numSet.add('4');
        transMap.put("five", '5');  numSet.add('5');
        transMap.put("six", '6');   numSet.add('6');
        transMap.put("seven", '7'); numSet.add('7');
        transMap.put("eight", '8'); numSet.add('8');
        transMap.put("nine", '9');  numSet.add('9');
        
        int answer = 0;
        char[] chArr = s.toCharArray();
        
        for(char c : chArr){
            if(!numSet.contains(c)){
                System.out.println(c);
            }
        }
        
        */
        int answer = 0;
        s = s.replaceAll("zero","0");
        s = s.replaceAll("one","1");
        s = s.replaceAll("two","2");
        s = s.replaceAll("three","3");
        s = s.replaceAll("four","4");
        s = s.replaceAll("five","5");
        s = s.replaceAll("six","6");
        s = s.replaceAll("seven","7");
        s = s.replaceAll("eight","8");
        s = s.replaceAll("nine","9");
        
        return Integer.valueOf(s);
    }
}