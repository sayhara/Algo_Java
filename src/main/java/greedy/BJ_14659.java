package greedy;
import java.io.*;
import java.util.*;

public class BJ_14659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int max=arr[0];
        int count=0;
        int result=0;

        for(int i=1;i<N;i++){
            if(max<arr[i]){
                max=arr[i];
                result=Math.max(result,count);
                count=0;
            }
            else count++;
        }

        result=Math.max(result,count);
        System.out.println(result);


    }
}
