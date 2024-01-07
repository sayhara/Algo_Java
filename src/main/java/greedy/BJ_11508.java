package greedy;
import java.io.*;
import java.util.*;

public class BJ_11508 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Integer arr[]=new Integer[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        long sum=0;
        for(int i=0;i<N;i++){
            if((i+1)%3==0) continue;
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
