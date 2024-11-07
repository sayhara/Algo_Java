package BAEKJOON.data_structure;

import java.io.*;
import java.util.*;

public class BJ_4358 {

    public static void main(String[] args) throws IOException {

        Scanner sc=new Scanner(System.in);
        HashMap<String, Integer> map=new HashMap<>();
        int cnt=0;

        while(sc.hasNext()){
            String s=sc.nextLine();

            map.put(s,map.getOrDefault(s,0)+1);
            cnt++;
        }

        List<String> keySet=new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        for(String s:keySet){
            double ratio=map.get(s)/(double)(cnt)*100;
            System.out.println(s+" "+String.format("%.4f",ratio));
        }
    }
}
