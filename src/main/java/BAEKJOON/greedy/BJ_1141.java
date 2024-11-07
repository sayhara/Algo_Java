package BAEKJOON.greedy;
import java.io.*;
import java.util.*;

public class BJ_1141 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<N;i++){
            String s=br.readLine();
            set.add(s);
        }

        ArrayList<String> list=new ArrayList<>();
        for(String s:set){
            list.add(s);
        }

        int mix=0;
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(i==j) continue;
                if(list.get(j).startsWith(list.get(i))){
                    mix++;
                    break;
                }
            }
        }

        System.out.println(list.size()-mix);

    }
}
