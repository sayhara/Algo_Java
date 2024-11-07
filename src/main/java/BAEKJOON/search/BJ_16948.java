package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_16948 {

    static int N;
    static int arr[][];
    static boolean visited[][];
    static int r1,r2,c1,c2;
    static int dr[]={-2,-2,0,0,2,2};
    static int dc[]={-1,1,-2,2,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        visited=new boolean[N][N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        r1=Integer.parseInt(st.nextToken());
        c1=Integer.parseInt(st.nextToken());
        r2=Integer.parseInt(st.nextToken());
        c2=Integer.parseInt(st.nextToken());

        System.out.println(bfs());

    }

    public static int bfs(){

        Queue<Node> q=new LinkedList<>();
        q.add(new Node(r1,c1,0));
        visited[r1][c1]=true;

        while(!q.isEmpty()){

            Node curNode=q.poll();

            if(curNode.r==r2 && curNode.c==c2){
                return curNode.value;
            }

            for(int i=0;i<6;i++){
                int nr=curNode.r+dr[i];
                int nc=curNode.c+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<N){
                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        q.add(new Node(nr,nc,curNode.value+1));
                    }
                }
            }
        }
        return -1;
    }

    public static class Node {

        int r;
        int c;
        int value;

        public Node(int r, int c, int value){
            this.r=r;
            this.c=c;
            this.value=value;
        }
    }
}
