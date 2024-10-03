package data_structure;
import java.io.*;
import java.util.*;

public class BJ_20920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            if(s.length()>=M) map.put(s,map.getOrDefault(s,0)+1);
        }

        List<String> result=new ArrayList<>(map.keySet());

        Collections.sort(result, new Comparator<String>(){

            public int compare(String s1, String s2){
                // 1순위 : 자주 등장
                if (Integer.compare(map.get(s1),map.get(s2))!=0) {
                    return Integer.compare(map.get(s2),map.get(s1));
                }
                // 2순위 : 길이
                if(s1.length()!=s2.length()){
                    return s2.length()-s1.length();
                }
                // 3순위 : 알파벳 순서
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb=new StringBuilder();
        for(String s:result){
            sb.append(s+"\n");
        }
        System.out.println(sb);

    }
}
