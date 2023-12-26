package greedy;

import java.io.*;
import java.util.*;

public class BJ_1202 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int jewel[][]=new int[N][2];
        int bag[]=new int[K];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            jewel[i][0]=Integer.parseInt(st.nextToken());   // 무게
            jewel[i][1]=Integer.parseInt(st.nextToken());   // 가격
        }

        Arrays.sort(jewel, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });

        for(int i=0;i<K;i++){
            bag[i]=Integer.parseInt(br.readLine());
        }

    }
}
