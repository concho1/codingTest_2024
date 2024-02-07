class Solution {
    public String solution(String s) {
        
        char[] chArr = s.toCharArray();
        boolean spaceFlag = true;
        
        for(int i=0; i<chArr.length; i++){
            if(chArr[i] == ' ') spaceFlag = true;
            else if(spaceFlag){ //공백 뒤이고 소문자인 경우에만 upper
                if('a'<= chArr[i] && chArr[i] <= 'z') chArr[i] -= 32;
                spaceFlag = false;
            }
            else{               //공백 뒤가 아니고 대문자인 경우에만 down
                if('A'<= chArr[i] && chArr[i] <= 'Z') chArr[i] += 32;
                spaceFlag = false;
            }
            
        }
        String answer = new String(chArr);
        return answer;
    }
}