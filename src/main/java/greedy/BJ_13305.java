package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        long road[]=new long[N-1];
        long liter[]=new long[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<road.length;i++){
            road[i]=Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<liter.length;i++){
            liter[i]=Long.parseLong(st.nextToken());
        }

        long sum=road[0]*liter[0];
        long value=liter[0];

        for(int i=0;i<road.length-1;i++){
            if(value>liter[i+1]){
                value=liter[i+1];
            }
            sum+=road[i+1]*value; // int * int => int, value 또한 long 초기화 필요
        }
        System.out.println(sum);
    }
}
