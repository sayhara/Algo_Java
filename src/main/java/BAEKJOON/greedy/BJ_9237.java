package BAEKJOON.greedy;
import java.io.*;
import java.util.*;

public class BJ_9237 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Integer B_tree[]=new Integer[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            B_tree[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B_tree,Collections.reverseOrder());

        Integer A_tree[]=new Integer[N];
        for(int i=0;i<N;i++){
            A_tree[i]=(i+1)+B_tree[i];
        }
        Arrays.sort(A_tree,Collections.reverseOrder());
        System.out.println(A_tree[0]+1);

    }
}
