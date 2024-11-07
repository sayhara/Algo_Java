package BAEKJOON.columbus_study_5th.week2;
import java.io.*;
import java.util.*;

public class BJ_12851 {

    static int N,K;
    static int time=Integer.MAX_VALUE;
    static int count=0;
    static int visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        visited=new int[100001];

        if(N>=K){
            System.out.println((N-K)+"\n1");
            return;
        }

        bfs();
        System.out.println(time);
        System.out.println(count);

    }

    public static void bfs(){

        Queue<Integer> q=new LinkedList<>();
        q.add(N);
        visited[N]=1;

        while(!q.isEmpty()){

            int now=q.poll();
            int nr=0;

            if(time<visited[now]) return;

            for(int i=0;i<3;i++){
                if(i==0){
                    nr=now-1;
                }
                else if(i==1){
                    nr=now+1;
                }
                else {
                    nr=now*2;
                }

                if(nr<0 || nr>100000) continue;

                if(nr==K){
                    time=visited[now];
                    count++;
                }

                // 처음 방문 && 이미 방문한 곳이라도 같은 시간에 방문했다면 OK
                if(visited[nr]==0 || visited[nr]==visited[now]+1){
                    q.add(nr);
                    visited[nr]=visited[now]+1;
                }
            }
        }
    }

}
