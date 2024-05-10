class Solution {
    public String solution(String pn) {
        return pn.replaceAll(".(?=.{4})", "*");
    }
}