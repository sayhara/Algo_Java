package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_17086 {

    static int N,M;
    static int arr[][];
    static boolean visited[][];
    static int max=Integer.MIN_VALUE;
    static int dr[]={-1,-1,-1,0,0,1,1,1};
    static int dc[]={-1,0,1,1,-1,-1,0,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==0) bfs(i,j);
            }
        }

        System.out.println(max);

    }

    public static void bfs(int r, int c){

        Queue<Node> q=new LinkedList<>();
        q.add(new Node(r,c,0));
        visited=new boolean[N][M];
        visited[r][c]=true;

        while(!q.isEmpty()){

            Node curNode=q.poll();
            int br=curNode.r; int bc=curNode.c;

            for(int i=0;i<8;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<M && !visited[nr][nc]){
                    if(arr[nr][nc]==0){
                        visited[nr][nc]=true;
                        q.add(new Node(nr,nc, curNode.diff+1));
                    }
                    else if(arr[nr][nc]==1){
                        max=Math.max(max, curNode.diff+1);
                        return;
                    }
                }
            }
        }
    }

    public static class Node {

        int r;
        int c;
        int diff;

        public Node(int r, int c, int diff){
            this.r=r;
            this.c=c;
            this.diff=diff;
        }
    }
}
