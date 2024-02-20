package search;
import java.io.*;
import java.util.*;

public class BJ_1504 {

    static int N,E;
    static ArrayList<Node> list[];
    static boolean visited[];
    static int dist[];
    static final int INF=1000*200000;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        visited=new boolean[N+1];
        dist=new int[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        st=new StringTokenizer(br.readLine());
        int v1=Integer.parseInt(st.nextToken());
        int v2=Integer.parseInt(st.nextToken());

        //1 -> v1 / v2 -> N
        int distA=0; // v1 -> v2
        int distB=0; // v2 -> v1

        distA+=dijkstra(1,v1);
        distA+=dijkstra(v1,v2);
        distA+=dijkstra(v2,N);

        distB+=dijkstra(1,v2);
        distB+=dijkstra(v2,v1);
        distB+=dijkstra(v1,N);

        int answer=(distA>=INF && distB>=INF)?-1:Math.min(distA,distB);
        System.out.println(answer);

    }

    public static int dijkstra(int start, int end){

        PriorityQueue<Node> pq=new PriorityQueue<>();
        Arrays.fill(visited,false);
        Arrays.fill(dist,INF);

        pq.add(new Node(start,0));
        dist[start]=0;

        while(!pq.isEmpty()){

            Node curNode=pq.poll();
            int now=curNode.end;

            if(!visited[now]) visited[now]=true;
            for(Node node : list[now]){
                if(dist[node.end]>dist[now]+node.weight){
                    dist[node.end]=dist[now]+node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }
        return dist[end];

    }

    public static class Node implements Comparable<Node>{

        int end;
        int weight;

        public Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
}




