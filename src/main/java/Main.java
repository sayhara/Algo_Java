import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0,0};
    static int dc[]={0,1,0,-1,0};
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        makeFlower(0,0);
        System.out.println(min);
    }

    public static void makeFlower(int cnt, int sum){

        if(cnt==3){
            min=Math.min(min,sum);
            return;
        }

        for(int i=1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                if(checkVisit(i,j)){
                    int value=visitAndSum(i,j);
                    makeFlower(cnt+1,sum+value);
                    visitFalse(i,j);
                }
            }
        }

    }

    public static boolean checkVisit(int r, int c){

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(visited[nr][nc]) return false;
        }
        return true;
    }

    public static int visitAndSum(int r, int c){

        int sum=0;

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            visited[nr][nc]=true;
            sum+=arr[nr][nc];
        }
        return sum;
    }

    public static void visitFalse(int r, int c){

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            visited[nr][nc]=false;
        }
    }
}
