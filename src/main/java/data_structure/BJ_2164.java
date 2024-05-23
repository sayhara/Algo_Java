package data_structure;

import java.io.*;
import java.util.*;

public class BJ_2164 {

    static Deque<Integer> q=new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++){
            q.add(i);
        }

        while(q.size()>1){
            q.pollFirst();
            q.addLast(q.pollFirst());
        }
        System.out.println(q.poll());
    }
}
