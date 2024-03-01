package search;
import java.io.*;
import java.util.*;

public class BJ_1389 {

    static final int INF=987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int graph[][]=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i!=j) graph[i][j]=INF;
            }
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            graph[A][B]=1;
            graph[B][A]=1;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=N;j++){
                if(i!=j) sum+=graph[i][j];
            }
            map.put(i,sum);
            min=Math.min(min,sum);
        }

        int num=Integer.MAX_VALUE;
        for(Integer i:map.keySet()){
            if(map.get(i)==min){
                if(num>i) num=i;
            }
        }
        System.out.println(num);
    }
}
