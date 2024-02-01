class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] myChArr = my_string.toCharArray();   char[] overChArr = overwrite_string.toCharArray();
        for(int i=s; i<overChArr.length+s; i++) myChArr[i] = overChArr[i-s];
        return String.valueOf(myChArr);
    }
}