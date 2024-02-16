/*
    class 설계 [User]
    멤버 : 
        내가 누구한테 선물을 줬는지(iGive)
        선물 지수(giftLevel)
        다음달에 받을 선물(nextGiftCnt)
    메소드:
        선물 받는 동작
        선물 주는 동작
        내가 특정 친구한테 선물을 얼마나 줬는지 return
*/
import java.util.*;

class User {
    private HashMap<String, Integer> iGive = new HashMap<String, Integer>();
    int giftLevel = 0;
    int nextGiftCnt = 0;
    
    void giftFrom(String name){         // 받는 동작
                                        giftLevel--;
    }
    
    void giftTo(String name){           // 주는 동작
                                        giftLevel++;
        if(iGive.containsKey(name))     iGive.put(name, iGive.get(name)+1);
        else                            iGive.put(name, 1);
    }
    
    int iGiveCnt(String name){          // 준 선물수 return
        if(iGive.containsKey(name))     return iGive.get(name);
        else                            return 0;
    }
}

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int answer                      = 0;
        var userMap                     = new HashMap<String, User>();
        
        for(String user : friends)        userMap.put(user,new User());
        
        for(String twoUser : gifts){
            
            String[] twoUserArr         = twoUser.split(" ");
            String   giver              = twoUserArr[0];
            String   reciver            = twoUserArr[1];
            User     giverUser          = userMap.get(giver);
            User     reciverUser        = userMap.get(reciver);
            
            giverUser.giftTo(reciver);
            reciverUser.giftFrom(giver);
        }
        
        
        for(int i=0; i < friends.length; i++){
            for(int j=i+1; j < friends.length; j++){
                String  name1            = friends[i];
                String  name2            = friends[j];
                User    user1            = userMap.get(name1);
                User    user2            = userMap.get(name2);
                
                if(user1.iGiveCnt(name2) > user2.iGiveCnt(name1)){            
                    user1.nextGiftCnt++;
                }else if(user1.iGiveCnt(name2) < user2.iGiveCnt(name1)){
                    user2.nextGiftCnt++;
                }else{
                    
                    if(user1.giftLevel > user2.giftLevel){
                        user1.nextGiftCnt++;
                    }else if(user1.giftLevel < user2.giftLevel){
                        user2.nextGiftCnt++;
                    }
                }
                if(answer < user1.nextGiftCnt)
                    answer = user1.nextGiftCnt;
                if(answer < user2.nextGiftCnt)
                    answer = user2.nextGiftCnt;
            }
        }
        
        return answer;
    }
}