import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int M=Integer.parseInt(br.readLine());
        String s=br.readLine();

        String chk="I";
        for(int i=0;i<N;i++){
            chk+="OI";
        }

        int cnt=0;
        for(int i=0;i<=s.length()-chk.length();i++){
            String s1=s.substring(i,i+chk.length());
            if(s1.equals(chk)){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
