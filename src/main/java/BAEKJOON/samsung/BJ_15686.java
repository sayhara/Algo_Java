package BAEKJOON.samsung;
import java.io.*;
import java.util.*;

public class BJ_15686 {

    static int N,M;
    static int arr[][];
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static boolean open[];
    static int result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][N];
        home=new ArrayList<>();
        chicken=new ArrayList<>();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    home.add(new Point(i,j));
                }
                else if(arr[i][j]==2){
                    chicken.add(new Point(i,j));
                }
            }
        }

        open=new boolean[chicken.size()];
        DFS(0,0);
        System.out.println(result);

    }

    public static void DFS(int start, int depth){

        if(depth==M){
            int sum=0;
            for(int i=0;i<home.size();i++){
                int value=Integer.MAX_VALUE;
                for(int j=0;j<chicken.size();j++){
                    if(open[j]){
                        int diff=Math.abs(home.get(i).r-chicken.get(j).r)+Math.abs(home.get(i).c-chicken.get(j).c);
                        value=Math.min(value,diff);
                    }
                }
                sum+=value;
            }
            result=Math.min(result,sum);
            return;
        }

        for(int i=start;i<chicken.size();i++){
            open[i]=true;
            DFS(i+1,depth+1);
            open[i]=false;
        }

    }

    public static class Point{

        int r;
        int c;

        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }

    }

}
