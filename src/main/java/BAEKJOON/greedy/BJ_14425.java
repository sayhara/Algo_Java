package BAEKJOON.greedy;

import java.io.*;
import java.util.*;

public class BJ_14425 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String s[]=new String[N];
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++){
            s[i]=br.readLine();
            map.put(s[i],map.getOrDefault(s[i],0)+1);
        }

        int cnt=0;
        for(int i=0;i<M;i++){
            String str=br.readLine();
            if(map.containsKey(str)) cnt++;
        }

        System.out.println(cnt);

    }
}
