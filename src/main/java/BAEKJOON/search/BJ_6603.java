package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_6603 {

    static int k;
    static int[] lotto;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());
            if(k==0) return;

            lotto=new int[k];
            visited=new boolean[k];
            for(int i=0;i<k;i++){
                lotto[i]=Integer.parseInt(st.nextToken());
            }
            combination(0,0);
            System.out.println();
        }

    }

    public static void combination(int start, int depth){

        if(depth==6){
            print();
            return;
        }

        for(int i=start;i<k;i++){
            if(!visited[i]){
                visited[i]=true;
                combination(i+1,depth+1);
                visited[i]=false;
            }
        }

    }

    public static void print(){

        for(int i=0;i<lotto.length;i++){
            if(visited[i]) System.out.print(lotto[i]+" ");
        }
        System.out.println();
    }
}
