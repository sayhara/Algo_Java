import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 1순위 : 절댓값 기준 작은 순
                if(Math.abs(o1)>Math.abs(o2)){
                    return Math.abs(o1)-Math.abs(o2);
                // 2순위 : 절댓값 동일 시 음수
                } else if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                } else {
                    return -1;
                }
            }
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());

            if(num!=0){
                pq.offer(num);
            }
            else {
                if(pq.isEmpty()){
                    sb.append("0"+"\n");
                } else {
                    sb.append(pq.poll()+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}