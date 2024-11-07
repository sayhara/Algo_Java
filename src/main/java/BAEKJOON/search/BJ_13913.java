package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_13913 {

    static int N,K;
    static int visited[]=new int[100001];
    static int parent[]=new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        bfs();

        Stack<Integer> stack=new Stack<>();
        int index=K;
        stack.add(K);

        while(index!=N){
            stack.push(parent[index]);
            index=parent[index];
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }


    public static void bfs(){

        Queue<Integer> q=new LinkedList<>();
        q.add(N);

        while(!q.isEmpty()){

            int now=q.poll();
            int next=0;

            if(now==K){
                System.out.println(visited[now]);
                return;
            }

            for(int i=0;i<3;i++){
                if(i==0) next=now-1;
                else if(i==1) next=now+1;
                else next=now*2;

                if(next>=0 && next<=100000 && visited[next]==0){
                    visited[next]=visited[now]+1;
                    q.add(next);
                    parent[next]=now;
                }
            }
        }
    }
}
