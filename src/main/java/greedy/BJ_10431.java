package greedy;
import java.io.*;
import java.util.*;

public class BJ_10431 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int P=Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<P;i++){
            st=new StringTokenizer(br.readLine());
            int seq=Integer.parseInt(st.nextToken());
            int arr[]=new int[20];
            for(int num=0;num<20;num++){
                arr[num]=Integer.parseInt(st.nextToken());
            }

            int count=0;
            for(int j=0;j<20;j++){
                for(int k=0;k<j;k++){
                    if(arr[k]>arr[j]) count++;
                }
            }
            System.out.println(seq+" "+count);
        }
    }

}
