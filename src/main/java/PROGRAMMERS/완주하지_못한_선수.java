package PROGRAMMERS;
import java.util.*;

public class 완주하지_못한_선수 {

    // 나의 풀이
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map=new HashMap<>();
            for(String s:participant){
                map.put(s,map.getOrDefault(s,0)+1);
            }
            for(String s:completion){
                if(map.get(s)>0){
                    map.replace(s,map.get(s)-1);
                }
            }
            for(String s:map.keySet()){
                if(map.get(s)>0){
                    answer=s;
                }
            }
            return answer;
        }
    }

    // 좋은 풀이
    class Solution2 {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            HashMap<String, Integer> map=new HashMap<>();
            for(String s:participant){
                map.put(s,map.getOrDefault(s,0)+1);
            }
            for(String s:completion){
                map.put(s,map.get(s)-1);
            }
            for(String s:map.keySet()){
                if(map.get(s)>0){
                    answer=s;
                }
            }
            return answer;
        }
    }
}
