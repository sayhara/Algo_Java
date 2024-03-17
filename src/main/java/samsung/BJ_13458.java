package samsung;
import java.io.*;
import java.util.*;

public class BJ_13458 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        int B=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

        long count=N; // 각각의 시험장에 총감독관 포함
        for(int i=0;i<N;i++){
            arr[i]-=B;
            if(arr[i]>0){
                count+=arr[i]/C;
                if(arr[i]%C>0) count++;
            }
        }
        System.out.println(count);
    }
}
