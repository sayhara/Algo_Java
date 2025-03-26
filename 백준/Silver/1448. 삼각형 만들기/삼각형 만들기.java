import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Integer arr[]=new Integer[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr,Collections.reverseOrder());

        int sum=0;
        for(int i=0;i<arr.length-2;i++){
            if(arr[i]<arr[i+1]+arr[i+2]){
                sum=arr[i]+arr[i+1]+arr[i+2];
                System.out.println(sum);
                return;
            }
        }
        System.out.println(-1);

    }
}