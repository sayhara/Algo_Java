package BAEKJOON.greedy;
import java.io.*;

public class BJ_1543 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s1=br.readLine();
        String s2=br.readLine();

        int count=0;
        while(s1.contains(s2)){
            s1=s1.replaceFirst(s2,"_");
            count++;
        }
        System.out.println(count);
    }
}
