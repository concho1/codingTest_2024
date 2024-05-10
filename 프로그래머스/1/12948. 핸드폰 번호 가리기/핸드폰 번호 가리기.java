class Solution {
    public String solution(String pn) {
        String re = "";
        for(int i=0; i< pn.length()-4; i++) re += "*";
        return re + pn.substring(pn.length()-4, pn.length());
    }
}