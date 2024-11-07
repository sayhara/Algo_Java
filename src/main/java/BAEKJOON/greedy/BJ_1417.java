package BAEKJOON.greedy;

import java.io.*;
import java.util.*;

public class BJ_1417 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int start=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<N-1;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt=0;
        while(!pq.isEmpty() && start<=pq.peek()){
            pq.add(pq.poll()-1);
            cnt++;
            start++;
        }
        System.out.println(cnt);
    }
}
