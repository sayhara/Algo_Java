package BAEKJOON.columbus_study_6th.week1;
import java.io.*;
import java.util.*;

public class BJ_1238 {

    static int N,M,X;
    static ArrayList<Node> list[], reverseList[];
    static int dist[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        list=new ArrayList[N+1];
        reverseList=new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
            reverseList[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            list[s].add(new Node(e,w));
            reverseList[e].add(new Node(s,w));
        }

        int dist1[]=dijkstra(list);
        int dist2[]=dijkstra(reverseList);

        int max=0;
        for(int i=1;i<=N;i++){
            max=Math.max(max,dist1[i]+dist2[i]);
        }
        System.out.println(max);

    }

    public static int[] dijkstra(ArrayList<Node> list[]){

        boolean visited[]=new boolean[N+1];
        dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[X]=0;

        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(X,0));

        while(!pq.isEmpty()){

            Node curNode = pq.poll();
            int curr=curNode.end;

            if(visited[curr]) continue;
            visited[curr]=true;

            for(Node node:list[curr]){
                if(dist[node.end]>dist[curr]+node.weight){
                    dist[node.end]=dist[curr]+node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }
        return dist;
    }

    public static class Node implements Comparable<Node>{

        int end;
        int weight;

        public Node(int end, int weight){
            this.end=end;
            this.weight=weight;
        }

        public int compareTo(Node o){
            return Integer.compare(this.weight,o.weight);
        }

    }
}
