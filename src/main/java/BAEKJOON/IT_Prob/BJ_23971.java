package BAEKJOON.IT_Prob;
import java.io.*;
import java.util.*;

public class BJ_23971 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int H=Integer.parseInt(st.nextToken());
        int W=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int height=(H-1)/(N+1)+1;
        int width=(W-1)/(M+1)+1;

        System.out.println(height*width);

    }
}
