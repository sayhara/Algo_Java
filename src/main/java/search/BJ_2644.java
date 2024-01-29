package search;
import java.io.*;
import java.util.*;

// 부모-자식문제 : 인접리스트, 인접행렬
public class BJ_2644 {

    static int n;
    static List<Integer>[] list;
    static boolean visited[];
    static int result=-1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        list=new ArrayList[n+1];
        visited=new boolean[n+1];

        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        int m=Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken()); // 부모
            int y=Integer.parseInt(st.nextToken()); // 자식
            list[x].add(y);
            list[y].add(x);
        }

        DFS(a,b,0);
        System.out.println(result);
    }

    public static void DFS(int start, int end, int cnt){

        if(start==end){
            result=cnt;
            return;
        }

        visited[start]=true;

        for(int i=0;i<list[start].size();i++){
            int next = list[start].get(i);
            if(!visited[next]){
                DFS(next,end,cnt+1);
            }
        }
    }
}
