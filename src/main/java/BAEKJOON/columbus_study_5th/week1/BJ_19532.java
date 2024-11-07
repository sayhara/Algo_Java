package BAEKJOON.columbus_study_5th.week1;
import java.io.*;
import java.util.*;

public class BJ_19532 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int f=Integer.parseInt(st.nextToken());

        for(int x_num=-999;x_num<=999;x_num++){
            for(int y_num=-999;y_num<=999;y_num++){
                if(a*x_num+b*y_num==c && d*x_num+e*y_num==f){
                    System.out.println(x_num+" "+y_num);
                    return;
                }
            }
        }
    }
}
