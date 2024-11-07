package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_13549 {

    static int N,K;
    static boolean visited[];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        visited=new boolean[100001];

        BFS();
        System.out.println(min);

    }

    public static void BFS(){

        Queue<Node> q=new LinkedList<>();
        q.add(new Node(N,0));
        visited[N]=true;

        while(!q.isEmpty()){

            Node curNode=q.poll();
            visited[curNode.num]=true;

            if(curNode.num==K){
                min=Math.min(min,curNode.time);
            }
            if(curNode.num+1<=100000 && !visited[curNode.num+1]){
                q.add(new Node(curNode.num+1,curNode.time+1));
            }

            if(curNode.num-1>=0 && !visited[curNode.num-1]){
                q.add(new Node(curNode.num-1,curNode.time+1));
            }
            if(curNode.num*2<=100000 && !visited[curNode.num*2]){
                q.add(new Node(curNode.num*2,curNode.time));
            }
        }
    }

    public static class Node {

        int num;
        int time;

        public Node(int num, int time){
            this.num=num;
            this.time=time;
        }
    }
}
