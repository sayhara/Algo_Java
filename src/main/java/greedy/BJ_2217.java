package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_2217 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Integer arr[]=new Integer[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int max=0;

        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]*(i+1));
        }

        System.out.println(max);

    }
}
