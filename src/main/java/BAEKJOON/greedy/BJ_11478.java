package BAEKJOON.greedy;
import java.io.*;
import java.util.*;

public class BJ_11478 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String tmp=s.substring(i,j);
                map.put(tmp, map.getOrDefault(tmp,0)+1);
            }
        }

        System.out.println(map.size());

    }
}
