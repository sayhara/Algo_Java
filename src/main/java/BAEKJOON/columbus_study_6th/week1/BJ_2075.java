package BAEKJOON.columbus_study_6th.week1;
import java.io.*;
import java.util.*;

public class BJ_2075 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[][]=new int[N][N];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                pq.add(arr[i][j]);
            }
        }

        for(int i=0;i<N-1;i++){
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}
