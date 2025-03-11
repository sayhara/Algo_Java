import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine()); // 컴퓨터의 수
        M=Integer.parseInt(br.readLine()); // 컴퓨터의 쌍
        list=new ArrayList[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=N;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            list[r].add(c);
            list[c].add(r);
        }

        dfs(1);
        System.out.println(count);

    }

    public static void dfs(int start){

        visited[start]=true;

        for(int i=0;i<list[start].size();i++){
            int num=list[start].get(i);
            if(!visited[num]){
                count++;
                dfs(num);
            }
        }
    }
}