package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_10451 {

    static int N;
    static int arr[];
    static boolean visited[];
    static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            N=Integer.parseInt(br.readLine());
            arr=new int[N+1];
            visited=new boolean[N+1];
            int count=0;

            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            for(int i=1;i<=N;i++){
                if(!visited[i]){
                    dfs(i);
                    count++;
                }
            }
            list.add(count);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int start){

        visited[start]=true;
        int num=arr[start];
        if(!visited[num]) dfs(num);

    }
}
