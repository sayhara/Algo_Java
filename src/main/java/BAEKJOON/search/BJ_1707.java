package BAEKJOON.search;
import java.io.*;
import java.util.*;

// 이분그래프 : 그래프의 정점을 두 개의 집합으로 나눴을 때, 각 집합에 속한 정점끼리는 서로 인접할 수 있도록 분할 가능
// 즉, 정점을 어떠한 방법으로든 두 개의 집합으로 나눴을 때, 각 집합의 정점끼리 간선이 존재하지 않게 나눌 수 있어야 함
 public class BJ_1707 {

    static int V,E;
    static ArrayList<Integer> list[];
    static int color[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int K=Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(K-->0){

            st=new StringTokenizer(br.readLine());
            V=Integer.parseInt(st.nextToken()); // 정점
            E=Integer.parseInt(st.nextToken()); // 간선
            list=new ArrayList[V+1];


            for(int i=1;i<=V;i++){
                list[i]=new ArrayList<>();
            }

            for(int i=0;i<E;i++){
                st=new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            color=new int[V+1];
            bfs();
        }
    }

    public static void bfs(){

        Queue<Integer> q=new LinkedList<>();

        for(int i=1;i<=V;i++){
            if(color[i]==0){
                color[i]=1;
                q.add(i);
            }

            while(!q.isEmpty()){

                int now=q.poll();

                for(int next:list[now]){
                    if(color[now]==color[next]){
                        System.out.println("NO");
                        return;
                    }

                    if(color[next]==0){
                        q.add(next);

                        if(color[now]==1){
                            color[next]=2;
                        } else {
                            color[next]=1;
                        }
                    }
                }
            }
        }
        System.out.println("YES");
    }

}
