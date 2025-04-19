class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s/n==0) return new int[]{-1};
        
        int div=s/n;
        int remain=s%n;
        
        for(int i=n-1;i>=0;i--){
            if(remain-->0){
                answer[i]=div+1;
            } else {
                answer[i]=div;
            }
        }
        
        return answer;
    }
}