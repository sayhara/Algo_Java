package samsung;

import java.io.*;
import java.util.*;

public class BJ_2212 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine()); // 센서의 개수
        int K=Integer.parseInt(br.readLine()); // 집중국의 개수
        int arr[]=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Integer diff[]=new Integer[N-1];
        for(int i=0;i<N-1;i++){
            diff[i]=Math.abs(arr[i]-arr[i+1]);
        }

        Arrays.sort(diff,Collections.reverseOrder());

        if(K>=N){
            System.out.println(0);
            return;
        }

        for(int i=0;i<K-1;i++){
            diff[i]=0;  // 나누는 영역
        }
        int sum=0;
        for(int i=0;i<diff.length;i++){
            sum+=diff[i];
        }

        System.out.println(sum);

    }
}
