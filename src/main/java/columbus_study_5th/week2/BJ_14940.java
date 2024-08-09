package columbus_study_5th.week2;
import java.io.*;
import java.util.*;

public class BJ_14940 {

    static int n,m;
    static int arr[][];
    static int result[][];
    static boolean visited[][];
    static int startR, startC;
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        result=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    startR=i;
                    startC=j;
                }
            }
        }
        bfs(startR,startC);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1 && !visited[i][j]) result[i][j]=-1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static void bfs(int r, int c){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        result[r][c]=0;
        visited[r][c]=true;

        while(!q.isEmpty()){

            int[] temp=q.poll();
            int br=temp[0];
            int bc=temp[1];

            for(int i=0;i<4;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    if(arr[nr][nc]==1 && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        result[nr][nc]=result[br][bc]+1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}
