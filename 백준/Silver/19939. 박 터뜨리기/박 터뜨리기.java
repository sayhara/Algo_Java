import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int min=0;
        for(int i=1;i<=K;i++){
            min+=i;
        }

        // 최소값 충족하지 못하는 경우
        if(N<min){
            System.out.println(-1);
        }
        else {
            // 나머지 존재
            if((N-min)%K!=0){
                System.out.println(K);
            }
            else {
                System.out.println(K-1);
            }
        }
    }
}