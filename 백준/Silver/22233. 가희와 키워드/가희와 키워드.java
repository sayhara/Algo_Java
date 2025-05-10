import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 키워드 수
        int M=Integer.parseInt(st.nextToken()); // 블로그 수
        Set<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            set.add(s);
        }
        for(int i=0;i<M;i++){
            String s=br.readLine();
            String[] split = s.split(",");
            for(int j=0;j< split.length;j++){
                if(set.contains(split[j])) set.remove(split[j]);
            }
            sb.append(set.size()+"\n");
        }
        System.out.println(sb);
    }
}