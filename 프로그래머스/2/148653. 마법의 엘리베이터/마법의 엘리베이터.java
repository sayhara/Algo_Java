class Solution {
    public int solution(int storey) {
        int answer = 0;
        int length=0;
        
        while(storey>0){
            
            int digit=storey%10;
            storey=storey/10;
            
            if(digit==5){
                if(storey%10>=5){
                    answer+=10-digit;
                    storey++;
                }
                else {
                    answer+=digit;
                }
            }
            
            else if(digit>5){
                answer+=10-digit;
                storey++;
            }
            else {
                answer+=digit;
            }
            
        }
        
        return answer;
    }
}