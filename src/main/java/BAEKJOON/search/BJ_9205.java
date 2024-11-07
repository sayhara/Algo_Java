package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_9205 {

    static int n;
    static int startR, startC, endR, endC;
    static List<Point> list;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int t=Integer.parseInt(br.readLine());

        while(t-->0){

            n=Integer.parseInt(br.readLine());
            list=new ArrayList<>();
            visited=new boolean[n];
            StringTokenizer st;
            for(int i=0;i<n+2;i++){
                st=new StringTokenizer(br.readLine());
                int r=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                if(i==0){
                    startR=r;
                    startC=c;
                }
                else if(i==n+1){
                    endR=r;
                    endC=c;
                }
                else {
                    list.add(new Point(r,c));
                }
            }

            System.out.println(bfs()?"happy":"sad");
        }
    }

    public static boolean bfs(){

        Queue<Point> q=new LinkedList<>();
        q.add(new Point(startR,startC));

        while(!q.isEmpty()) {
            Point temp=q.poll();
            if(Math.abs(temp.r-endR)+Math.abs(temp.c-endC)<=1000){
                return true;
            }

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    Point next = list.get(i);
                    if(Math.abs(next.r-temp.r)+Math.abs(next.c-temp.c)<=1000){
                        visited[i]=true;
                        q.add(next);
                    }
                }
            }
        }
        return false;
    }

    public static class Point {

        int r;
        int c;

        public Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
