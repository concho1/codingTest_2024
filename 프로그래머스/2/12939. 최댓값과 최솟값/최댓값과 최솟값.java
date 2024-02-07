class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        long maxValue = Long.MIN_VALUE, minValue = Long.MAX_VALUE;
        
        for(String str : sArr){
            long tmLong = Long.valueOf(str);
            if(maxValue < tmLong) maxValue = tmLong;
            if(minValue > tmLong) minValue = tmLong;
        }
        return String.valueOf(minValue) +" "+ String.valueOf(maxValue);
    }
}