class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int num=1;num<=n;num++){
            int sum=0;
            for(int i=num;i<=n;i++){
                sum+=i;
                if(sum==n) answer++;
                else if(sum>n) break;
            }
        }
        
        return answer;
    }
}