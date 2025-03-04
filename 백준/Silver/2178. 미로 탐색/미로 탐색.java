import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        bfs(0,0);

    }

    public static void bfs(int r, int c){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c]=true;

        while(!q.isEmpty()){

            int[] temp=q.poll();

            if(temp[0]==N-1 && temp[1]==M-1){
                System.out.println(arr[N-1][M-1]);
                return;
            }

            for(int i=0;i<4;i++){
                int nr=temp[0]+dr[i];
                int nc=temp[1]+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<M){
                    if(!visited[nr][nc] && arr[nr][nc]==1){
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc});
                        arr[nr][nc]=arr[temp[0]][temp[1]]+1;
                    }
                }
            }
        }
    }
}
