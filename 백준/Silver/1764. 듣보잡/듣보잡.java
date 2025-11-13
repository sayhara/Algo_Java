import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 듣 사람의 수
        int M=Integer.parseInt(st.nextToken()); // 보 사람의 수

        HashMap<String, Integer> map=new HashMap<>();
        for(int i=0;i<N+M;i++){
            String s=br.readLine();
            map.put(s,map.getOrDefault(s,0)+1);
        }

        ArrayList<String> list=new ArrayList<>();
        for(String s:map.keySet()){
            if(map.get(s)>=2){
                list.add(s);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
