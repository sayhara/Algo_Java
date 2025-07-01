import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int x=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<x;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()+"\n");
            } else {
                pq.add(num);
            }
        }

        System.out.println(sb);

    }
}