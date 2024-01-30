import java.util.*;
class Solution {
    class Data{
        String name;
        Integer start;
        Integer playtime;
        public Data(){}
        public Data(String[] str){
            String name = str[0], start = str[1], playtime = str[2];
            String[] s = start.split(":");
            this.name = name;
            this.start = 60*Integer.valueOf(s[0])+Integer.valueOf(s[1]);
            this.playtime = Integer.valueOf(playtime);
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        /*
        * plans 의 크기 1000*3
        * [name, start, playtime]
        * 모든 과제의 시작 시각은 달라
        * String 시간을 분당위 정수로 환산 + 정렬
        * 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작
        */
        var an = new LinkedList<String>();
        var pList = new LinkedList<Data>();
        for(String[] p : plans) pList.add(new Data(p));
        
        Collections.sort(pList, (a, b) -> a.start.compareTo(b.start)); 
        
        // 시작시간 순으로 불러오기
        var waitList = new LinkedList<Data>();
        Integer endTime = 0; 
        boolean runFlag = false;
        Data p = new Data(); //현재 진행중인 작업
        while( !pList.isEmpty() ){
            Data newP = pList.pop();
            // 다음 과제 시작시간 이전 까지의 로직 처리
            if(endTime <= newP.start) an.add(p.name);
            while(endTime < newP.start && !waitList.isEmpty()){
                p = waitList.pollLast();
                endTime += p.playtime;
                if(endTime <= newP.start) an.add(p.name);
            }
            // 진행중인 작업 없을때
            if(endTime <= newP.start){
                p = newP;
                endTime = p.start + p.playtime;
            // 작업 진행중일때
            }else{
                p.playtime = endTime - newP.start; //남은 작업 시간 계산
                waitList.add(p);
                p = newP;
                endTime = p.start + p.playtime;
            }
        }
        an.add(p.name);
        // 대기열에 작업이 남아있으면
        while(!waitList.isEmpty()){
            p = waitList.pollLast();
            an.add(p.name);
        }
        
        an.pop();
        for(int i=0; i< answer.length; i++){
            answer[i] = an.pop();
        }
        return answer;
    }
}