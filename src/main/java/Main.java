import java.io.*;
import java.util.*;

// 2212
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int J=Integer.parseInt(br.readLine());
        int from=1, to=M;
        int sum=0;
        for(int i=0;i<J;i++){
            int value=Integer.parseInt(br.readLine());

            if(from<=value && to>=value) continue;

            if(value>to){
                int diff=value-to;
                from+=diff;
                to+=diff;
                sum+=diff;
            } else if(value<from){
                int diff=from-value;
                from-=diff;
                to-=diff;
                sum+=diff;
            }

        }
        System.out.println(sum);

    }
}