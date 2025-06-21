import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            String s[]=br.readLine().split(" ");
            map.put(s[0],s[1]);
        }

        for(int i=0;i<M;i++){
            String s=br.readLine();
            sb.append(map.get(s)+"\n");
        }
        System.out.println(sb);
    }

}