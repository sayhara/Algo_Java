package columbus_study_5th.week2;
import java.io.*;
import java.util.*;

public class BJ_2606 {

    static int cnt=0;
    static int N,M;
    static ArrayList<Integer> list[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        list=new ArrayList[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);
        System.out.println(cnt);

    }

    public static void dfs(int start){

        visited[start]=true;

        for(int num:list[start]){
            if(!visited[num]){
                dfs(num);
                cnt++;
            }
        }
    }
}
