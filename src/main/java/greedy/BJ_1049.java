package greedy;

import java.io.*;
import java.util.*;

public class BJ_1049 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int pack[]=new int[M];
        int single[]=new int[M];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            pack[i]=Integer.parseInt(st.nextToken()); // 6개 가격
            single[i]=Integer.parseInt(st.nextToken()); // 낱개 가격
        }

        Arrays.sort(pack);
        Arrays.sort(single);

        int val=N/6;
        int remain=N%6;

        int num1=val*pack[0]+remain*single[0];
        int num2=single[0]*N;
        int num3=(val+1)*pack[0];
        int check=Math.min(num1,num2);
        int min=Math.min(check,num3);

        System.out.println(min);

    }
}
