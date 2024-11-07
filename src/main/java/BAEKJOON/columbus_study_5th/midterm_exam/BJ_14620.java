package BAEKJOON.columbus_study_5th.midterm_exam;
import java.io.*;
import java.util.*;

public class BJ_14620 {

    static int N;
    static int flower[][];
    static boolean visited[][];
    static int min=Integer.MAX_VALUE;
    static int dr[]={0,-1,0,1,0};
    static int dc[]={0,0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        flower=new int[N][N];
        visited=new boolean[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                flower[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        makeFlower(0,0);
        System.out.println(min);

    }

    public static void makeFlower(int cnt, int result){

        if(cnt==3){
            min=Math.min(min,result);
            return;
        }

        for(int i=1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                if(checkVisit(i,j)){
                    int sum=VisitAndSum(i,j);
                    makeFlower(cnt+1,result+sum);
                    visitFalse(i,j);
                }
            }
        }
    }

    public static boolean checkVisit(int r, int c){

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc]){
                return false;
            }
        }
        return true;
    }

    public static int VisitAndSum(int r, int c){

        int sum=0;

        for(int i=0;i<5;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            visited[nr][nc]=true;
            sum+=flower[nr][nc];
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
