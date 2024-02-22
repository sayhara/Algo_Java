package search;
import java.io.*;
import java.util.*;

public class BJ_1753 {

    static int V,E,K;
    static ArrayList<Node> list[];
    static boolean visited[];
    static int dist[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        V=Integer.parseInt(st.nextToken()); // 정점의 개수
        E=Integer.parseInt(st.nextToken()); // 간선의 개수
        K=Integer.parseInt(br.readLine()); // 시작 정점

        list=new ArrayList[V+1];
        visited=new boolean[V+1];
        dist=new int[V+1];

        for(int i=1;i<=V;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[u].add(new Node(v,w));
        }

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[K]=0;
        dijkstra();

        for(int i=1;i<=V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(){

        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(K,0));

        while(!pq.isEmpty()){

            Node curNode=pq.poll();
            int now=curNode.end;
            if(visited[now]) continue;

            visited[now]=true;
            for(Node node:list[now]){
                if(dist[node.end]>dist[now]+node.weight){
                    dist[node.end]=dist[now]+node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

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


