package search;
import java.io.*;
import java.util.*;

public class BJ_24479 {

    static int N,M,R;
    static ArrayList<Integer> list[];
    static int result[];
    static int cnt=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); // 정점
        M=Integer.parseInt(st.nextToken()); // 간선
        R=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        result=new int[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for(int i=1;i<=N;i++){
            Collections.sort(list[i]);
        }

        DFS(R);
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(result[i]+"\n");
        }
        System.out.println(sb);

    }

    public static void DFS(int start){

        result[start]=cnt;

        for(int num:list[start]){
            if(result[num]==0){
                cnt++;
                DFS(num);
            }
        }
    }
}
