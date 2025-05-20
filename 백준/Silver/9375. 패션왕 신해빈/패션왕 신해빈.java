import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        while(T-->0){

            HashMap<String, Integer> map=new HashMap<>();
            int n=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                String s[]=br.readLine().split(" ");
                map.put(s[1],map.getOrDefault(s[1],0)+1);
            }

            int sum=1;
            for(String s:map.keySet()){
                sum*=(map.get(s)+1);
            }
            sum--;
            sb.append(sum+"\n");
        }

        System.out.println(sb);
    }

}