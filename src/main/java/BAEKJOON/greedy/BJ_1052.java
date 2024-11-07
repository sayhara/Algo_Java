package BAEKJOON.greedy;
import java.io.*;
import java.util.*;

public class BJ_1052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        if(N<=K){
            System.out.println(0);
            return;
        }

        int bottle=0;
        while(true){    // 물병 하나로 합치는 과정

            int cnt=0;
            int remain=N+bottle;

            while(remain!=0){
                if(remain%2==1){
                    cnt++;
                }
                remain/=2;
            }
            if(cnt<=K)
                break;
            bottle++;
        }
        System.out.println(bottle);

    }
}
