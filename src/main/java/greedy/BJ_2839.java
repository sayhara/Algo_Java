package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int div=N/5; // 몫 3
        int mod=N%5; // 나머지 3
        int idx=div;

        int result=0;
        for(int i=0;i<=idx;i++){
            if(mod%3==0){
                result=mod/3+div;
                System.out.println(result);
                return;
            }
            div--;
            mod+=5;
        }
        System.out.println(-1);

    }
}
