package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        ArrayList<Long> list=new ArrayList<>();

        while(T-->0){

            int N=Integer.parseInt(br.readLine());
            int arr[]=new int[N];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            long sum=0;
            long max=0;
            for(int i=N-1;i>=0;i--){
                if(arr[i]>max){
                    max=arr[i];
                } else {
                    sum+=max-arr[i];
                }
            }
            list.add(sum);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
