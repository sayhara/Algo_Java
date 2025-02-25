import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            map.put(s, map.getOrDefault(s,0)+1);
        }

        // max value 체크
        int max=0;
        for(String s:map.keySet()){
            if(map.get(s)>max){
                max=map.get(s);
            }
        }

        ArrayList<String> list=new ArrayList<>();
        for(String s:map.keySet()){
            if(map.get(s)==max) list.add(s);
        }

        Collections.sort(list);
        System.out.println(list.get(0));

    }
}