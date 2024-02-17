package search;
import java.io.*;
import java.util.*;

public class BJ_5014 {

    static int F,S,G,U,D;
    static int visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        F=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        U=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        visited=new int[1000001];

        BFS();

    }

    public static void BFS(){

        Queue<Integer> q=new LinkedList<>();
        q.add(S);
        visited[S]=1;

        while(!q.isEmpty()){

            int temp=q.poll();

            if(temp==G){
                System.out.println(visited[temp]-1);
                return;
            }

            int up=temp+U;
            int down=temp-D;
            if(up<=F && visited[up]==0){
                q.add(up);
                visited[up]=visited[temp]+1;
            }
            if(down>=1 && visited[down]==0){
                q.add(down);
                visited[down]=visited[temp]+1;
            }
        }
        System.out.println("use the stairs");
    }
}
