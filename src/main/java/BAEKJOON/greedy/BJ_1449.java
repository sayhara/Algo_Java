package BAEKJOON.greedy;

import java.io.*;
import java.util.*;

public class BJ_1449 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int tape[]=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            tape[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tape);

        double start=tape[0]-0.5;
        double end=start+L-0.5;
        int count=1;

        for(int i=1;i<tape.length;i++){
            if(end<=tape[i]-0.5){
                start=tape[i]-0.5;
                end=start+L;
                count++;
            }
        }
        System.out.println(count);
    }
}
