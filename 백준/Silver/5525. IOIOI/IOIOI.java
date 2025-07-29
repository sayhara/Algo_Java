import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        String s=br.readLine();
        int count=0;
        int ans=0;

        for(int i=1;i<M-1;){
            if(s.charAt(i)=='O' && s.charAt(i+1)=='I'){
                count++;
                if(count==N){
                    if(s.charAt(i+1-2*count)=='I'){
                        ans++;
                    }
                    count--;
                }
                i+=2;
            }
            else{
                count=0;
                i++;
            }
        }

        System.out.println(ans);
    }
}