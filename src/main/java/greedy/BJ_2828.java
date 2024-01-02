package greedy;
import java.io.*;
import java.util.*;

public class BJ_2828 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int J=Integer.parseInt(br.readLine());
        int arr[]=new int[J];
        for(int i=0;i<J;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int min=1, max=M;
        int sum=0;
        for(int i=0;i<J;i++) {

            if (max < arr[i]) {
                sum += arr[i] - max;
                min += arr[i] - max;
                max = arr[i];
            } else if (min > arr[i]) {
                sum += min - arr[i];
                max -= min - arr[i];
                min = arr[i];
            }
        }
        System.out.println(sum);
    }
}
