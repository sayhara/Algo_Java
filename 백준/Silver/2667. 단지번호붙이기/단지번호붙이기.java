import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static ArrayList<Integer> list=new ArrayList<>();
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j] && arr[i][j]==1){
                    count=1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int r, int c){

        visited[r][c]=true;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nc>=0 && nr<N && nc<N){
                if(!visited[nr][nc] && arr[nr][nc]==1){
                    dfs(nr,nc);
                    count++;
                }
            }
        }
    }
}