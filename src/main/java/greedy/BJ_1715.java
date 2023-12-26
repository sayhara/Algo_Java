package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1715 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            pq.add(Long.parseLong(br.readLine()));
        }

        long sum=0;
        while(pq.size()>1){
            long a = pq.poll();
            long b = pq.poll();
            sum+=a+b;
            pq.add(a+b);
        }
        System.out.println(sum);

    }
}
