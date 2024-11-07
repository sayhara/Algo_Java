package BAEKJOON.greedy;
import java.io.*;
import java.util.*;

public class BJ_1138 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N+1];
        ArrayList<Integer> list=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>=1;i--){
            list.add(arr[i],i);
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }
}
