import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char s[]=br.readLine().toCharArray();
        char duck[]={'q','u','a','c','k'};

        if(s.length%5!=0){
            System.out.println(-1);
            return;
        }

        int result=0;
        int total=s.length;

        while(true){

            int h_cnt=0; // 울음소리 count
            int d_cnt=0; // 배열 count
            int temp[]=new int[5];
            boolean chk=false;

            for(int i=0;i<s.length;i++){
                if(s[i]==duck[h_cnt]){
                    temp[d_cnt]=i;
                    h_cnt++;
                    d_cnt++;
                }

                if(h_cnt==5){
                    chk=true;
                    h_cnt=0;
                    d_cnt=0;
                    total-=5;
                    for(int j=0;j<5;j++){
                        s[temp[j]]='.';
                    }
                }
            }
            if(chk) result++;
            else {
                System.out.println(-1);
                return;
            }

            if(total==0) break;
        }
        System.out.println(result);
    }

}