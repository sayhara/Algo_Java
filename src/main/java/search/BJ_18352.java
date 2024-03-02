package search;
import java.io.*;
import java.util.*;

public class BJ_18352 {

    static int N,M,K,X;
    static ArrayList<Integer> list[];
    static int dist[];
    static final int INF=-1;
    static ArrayList<Integer> result=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        dist=new int[N+1];
        Arrays.fill(dist,INF);

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[r].add(c);
        }

        BFS(X);

        if(result.size()==0){
            System.out.println(-1);
            return;
        }

        Collections.sort(result);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }

    public static void BFS(int start){

        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        dist[X]=0;

        while(!q.isEmpty()){

            int temp=q.poll();
            if(dist[temp]==K) result.add(temp);

            for(int next:list[temp]){
                if(dist[next]==-1){
                    dist[next]=dist[temp]+1;
                    q.add(next);
                }
            }
        }
    }
}
