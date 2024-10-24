import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static boolean prime[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        prime=new boolean[N+1];

        check_prime();
        for(int i=M;i<=N;i++){
            if(!prime[i]){
                System.out.println(i);
            }
        }

    }

    public static void check_prime(){

        prime[0]=prime[1]=true;

        for(int i=2;i<=Math.sqrt(prime.length);i++){ // 제곱근
            if(prime[i]) continue;
            for(int j=i*i;j<prime.length;j=j+i){
                prime[j]=true;
            }
        }

    }
}