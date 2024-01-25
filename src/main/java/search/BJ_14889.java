package search;
import java.io.*;
import java.util.*;

public class BJ_14889 {

    static int N;
    static int arr[][];
    static boolean visited[];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        combination(0,0);
        System.out.println(min);

    }

    public static void combination(int start, int depth){

        if(depth==N/2){
            diff();
            return;
        }

        for(int i=start;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                combination(i+1,depth+1);
                visited[i]=false;
            }
        }
    }

    public static void diff(){

        int startTeam=0;
        int linkTeam=0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visited[i] && visited[j]){
                    startTeam+=arr[i][j]+arr[j][i];
                }
                else if(!visited[i] && !visited[j]){
                    linkTeam+=arr[i][j]+arr[j][i];
                }
            }
        }

        int diff=Math.abs(startTeam-linkTeam);
        min=Math.min(diff,min);

    }
}
