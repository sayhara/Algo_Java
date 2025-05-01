import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken()); // 포켓몬의 개수
        int M=Integer.parseInt(st.nextToken()); // 문제의 수
        HashMap<Integer, String> hash1=new HashMap<>();
        HashMap<String, Integer> hash2=new HashMap<>();

        for(int i=1;i<=N;i++){
            String s=br.readLine();
            hash1.put(i,s);
            hash2.put(s,i);
        }

        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=M;i++){
            String s=br.readLine();
            // integer 입력 -> string 출력
            if(s.charAt(0)>='1' && s.charAt(0)<='9'){
                sb.append(hash1.get(Integer.parseInt(s))+"\n");
            }
            // string 입력 -> integer 출력
            else {
                sb.append(hash2.get(s)+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}