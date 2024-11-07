package BAEKJOON.columbus_study_6th.week3;
import java.io.*;
import java.util.*;

// 첫번째 스위치를 기준으로 체크
public class BJ_16234 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());
        int arr[][]=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

    }
}
