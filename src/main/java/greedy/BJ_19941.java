package greedy;
import java.io.*;
import java.util.*;

public class BJ_19941 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        String s=br.readLine();

        // 1 : 앞에서부터 탐색
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='P'){
                int min=i-K<0?0:i-K;
                int max=i+K>N-1?N-1:i+K;
                for(int j=min;j<=max;j++){
                    if(s.charAt(j)=='H'){
                        s=s.substring(0,j)+'A'+s.substring(j+1);
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
