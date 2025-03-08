import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1,o2) -> {
            return o1[1]-o2[1];
        });
        
        int dist=0;
        for(int i=0;i<targets.length;i++){
            if(dist<=targets[i][0]){
                dist=targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}