package BAEKJOON.columbus_study_5th.week3;
import java.io.*;
import java.util.*;

public class BJ_7562 {

    static int l;
    static int chess[][];
    static int min;
    static int startR, startC, endR, endC;
    static int dr[]={-2,-2,-1,-1,1,2,1,2};
    static int dc[]={1,-1,2,-2,2,1,-2,-1};
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T-->0){

            l=Integer.parseInt(br.readLine());
            chess=new int[l][l];
            st=new StringTokenizer(br.readLine());
            startR=Integer.parseInt(st.nextToken());
            startC=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            endR=Integer.parseInt(st.nextToken());
            endC=Integer.parseInt(st.nextToken());

            bfs();
            sb.append(min+"\n");
        }
        System.out.println(sb.toString());

    }

    public static void bfs(){

        Queue<Node> q=new LinkedList<>();
        boolean visited[][]=new boolean[l][l];
        q.add(new Node(startR,startC,0));
        visited[startR][startC]=true;
        min=Integer.MAX_VALUE;

        while(!q.isEmpty()){

            Node curNode=q.poll();

            if(curNode.r==endR && curNode.c==endC){
                min=Math.min(min,curNode.cnt);
                return;
            }

            for(int i=0;i<8;i++){
                int nr=curNode.r+dr[i];
                int nc=curNode.c+dc[i];

                if(nr>=0 && nc>=0 && nr<l && nc<l){
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        q.add(new Node(nr,nc, curNode.cnt+1));
                    }
                }
            }
        }
    }

    public static class Node {

        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }

    }
}
