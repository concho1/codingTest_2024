import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer              = 0;
        var numSet              = new HashSet<Integer>();
        for(int num : numbers)  numSet.add(num);
        for(int i=0; i<10; i++) answer += numSet.contains(i) ? 0 : i;
        return answer;
    }
}