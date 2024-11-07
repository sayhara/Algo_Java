package BAEKJOON.samsung;
import java.io.*;
import java.util.*;

// https://zero-iron.tistory.com/19

public class BJ_16236 {

    static int N;
    static int arr[][];
    static int startR, startC;
    static int dr[]={-1,0,0,1};
    static int dc[]={0,-1,1,0};
    static int now[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine()); // 공간의 크기
        arr=new int[N][N];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==9){
                    now=new int[]{i,j};
                    arr[i][j]=0;
                }
            }
        }

        int size=2;
        int eat=0; // 먹은 물고기
        int move=0;

        while(true){
            PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->
                    o1[2]!=o2[2]?Integer.compare(o1[2],o2[2]):(o1[0]!=o2[0]?Integer.compare(o1[0],o2[0]):Integer.compare(o1[1],o2[1]))
            );
            boolean visited[][]=new boolean[N][N];

            pq.add(new int[]{now[0],now[1],0});
            visited[now[0]][now[1]]=true;
            boolean chk=false; // 먹이를 먹었는지 체크

            while(!pq.isEmpty()){

                now=pq.poll();
                int r=now[0];
                int c=now[1];

                if(arr[r][c]!=0 && arr[r][c]<size){
                    arr[r][c]=0;
                    eat++;
                    move+=now[2];
                    chk=true;
                    break;
                }

                for(int i=0;i<4;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];

                    if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc] || arr[nr][nc]>size) continue;
                    pq.add(new int[]{nr,nc,now[2]+1});
                    visited[nr][nc]=true;
                }
            }

            if(!chk) break; // 큐가 비워질때까지 먹이를 안먹었다면 탈출

            if(size==eat){
                size++;
                eat=0;
            }
        }

        System.out.println(move);

    }
}
