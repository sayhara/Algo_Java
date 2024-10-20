package greedy;
import java.io.*;
import java.util.*;

public class BJ_2002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=1;i<=N;i++){
            map.put(br.readLine(), i);
        }

        String first=br.readLine();
        int max=map.get(first);
        int cnt=0;
        for(int i=2;i<=N;i++){
            String s=br.readLine();
            if(map.get(s)<max){
                cnt++;
            }
            max=map.get(s);
        }
        System.out.println(cnt);
    }


}
