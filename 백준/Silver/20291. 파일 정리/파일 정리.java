import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            String[] split = s.split("[.]");
            map.put(split[1],map.getOrDefault(split[1],0)+1);
        }

        ArrayList<String> list=new ArrayList<>(map.keySet());
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))){
                System.out.println(list.get(i)+" "+map.get(list.get(i)));
            }
        }
    }
}