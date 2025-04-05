import java.util.*;

class Solution {
    
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int sum;
    static int N,M;
    static String[] MAP;
    static boolean visited[][];
    static ArrayList<Integer> list=new ArrayList<>();
    
    public int[] solution(String[] maps) {
        
        N=maps.length;
        M=maps[0].length();
        MAP=maps;
        visited=new boolean[N][M];
        
        for(int i=0;i<maps.length;i++){
            String s=maps[i];
            
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)!='X' && !visited[i][j]){
                    sum=0;
                    dfs(i,j);
                    list.add(sum);
                }
            }
        }
        
        int answer[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        if(answer.length==0){
            answer=new int[1];
            answer[0]=-1;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public static void dfs(int r, int c){
        
        visited[r][c]=true;
        sum+=MAP[r].charAt(c)-'0';
        
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            
            if(nr>=0 && nc>=0 && nr<N && nc<M){
                if(!visited[nr][nc] && MAP[nr].charAt(nc)!='X'){
                    dfs(nr,nc);
                }
            }
        }
    }
}