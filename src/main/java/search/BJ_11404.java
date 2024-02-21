package search;
import java.io.*;
import java.util.*;

public class BJ_11404 {

    static final int INF=987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int graph[][]=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j) graph[i][j]=INF;
            }
        }

        for(int i=0;i<m;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            graph[a][b]=Math.min(graph[a][b],c);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][j]>graph[i][k]+graph[k][j]){
                        graph[i][j]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(graph[i][j]==INF){
                    System.out.print(0+" ");
                }
                else System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
