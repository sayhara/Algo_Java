package greedy;
import java.io.*;
import java.util.*;

public class BJ_2012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int grade[]=new int[N];

        long sum=0;
        for(int i=0;i<N;i++){
            grade[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(grade);

        for(int i=0;i<N;i++){
            sum+=Math.abs(grade[i]-(i+1));
        }
        System.out.println(sum);
    }
}
