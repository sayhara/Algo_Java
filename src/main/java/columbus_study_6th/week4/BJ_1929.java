package columbus_study_6th.week4;
import java.io.*;
import java.util.*;

// 에라토스테네스의 체
public class BJ_1929 {

    static int M,N;
    static boolean prime[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        prime=new boolean[N+1];
        prime_check();
        for(int i=M;i<=N;i++){
            if(!prime[i]) System.out.println(i);
        }

    }

    public static void prime_check(){

        // TRUE : 소수아님
        prime[0]=prime[1]=true;
        // 소수라면, 배수들은 제외
        for(int i=2;i<=Math.sqrt(prime.length);i++){
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j]=true;
            }
        }
    }
}
