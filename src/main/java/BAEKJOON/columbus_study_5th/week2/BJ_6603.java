package BAEKJOON.columbus_study_5th.week2;
import java.io.*;
import java.util.*;

public class BJ_6603 {

    static int k;
    static int arr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st=new StringTokenizer(br.readLine());

            k=Integer.parseInt(st.nextToken());
            arr=new int[k];
            visited=new boolean[k];

            for(int i=0;i<k;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            if(k==0) return;
            check(0,0);
            System.out.println();

        }

    }

    public static void check(int start, int cnt){

        if(cnt==6){
            for(int i=0;i<k;i++){
                if(visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }

        for(int i=start;i<k;i++){
            if(!visited[i]){
                visited[i]=true;
                check(i+1,cnt+1);
                visited[i]=false;
            }
        }
    }
}
