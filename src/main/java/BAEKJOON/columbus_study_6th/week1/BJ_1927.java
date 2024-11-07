package BAEKJOON.columbus_study_6th.week1;
import java.io.*;
import java.util.*;

public class BJ_1927 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            if(num!=0) pq.add(num);
            else {
                sb.append(!pq.isEmpty()?pq.poll()+"\n":0+"\n");
            }
        }
        System.out.println(sb);
    }
}
