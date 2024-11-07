package BAEKJOON.columbus_study_5th.week1;
import java.io.*;
import java.util.*;

public class BJ_18312 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int count=0;
        for(int hour=0;hour<=N;hour++){
            for(int minute=0;minute<60;minute++){
                for(int second=0;second<60;second++){
                    if(hour%10==K || hour/10==K || minute%10==K || minute/10==K || second%10==K || second/10==K) count++;
                }
            }
        }
        System.out.println(count);
    }
}