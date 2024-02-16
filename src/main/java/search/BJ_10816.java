package search;
import java.io.*;
import java.util.*;

public class BJ_10816 {

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        HashMap<Integer,Integer> map=new HashMap<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int M=Integer.parseInt(br.readLine());
        int arr2[]=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            int result=map.get(arr2[i])==null?0:map.get(arr2[i]);
            sb.append(result+" ");
        }
        System.out.println(sb.toString());
    }
}
