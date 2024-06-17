package search;
import java.io.*;
import java.util.*;

public class BJ_2331 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int A=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());
        ArrayList<Integer> list=new ArrayList<>();
        list.add(A);

        while(true){

            String s=Integer.toString(A);
            int sum=0;
            for(int i=0;i<s.length();i++){
                int num = s.charAt(i) - '0';
                sum+=Math.pow(num,P);
            }
            if(!list.contains(sum)) list.add(sum);
            else{
                int idx=list.indexOf(sum);
                System.out.println(idx);
                return;
            }
            A=sum;
        }
    }
}
