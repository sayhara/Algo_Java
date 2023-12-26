package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2847 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int sum=0;
        int last=arr[N]-1;
        for(int i=N-1;i>0;i--){
            if(arr[i]-last>0) sum+=arr[i]-last;
            else if(arr[i]-last<0) last=arr[i];
            last--;
        }

        System.out.println(sum);

    }
}
