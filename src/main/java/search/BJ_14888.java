package search;
import java.io.*;
import java.util.*;

public class BJ_14888 {

    static int N;
    static int arr[];
    static int op[];
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        op=new int[4]; // 순서 : +, -, x, /

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            op[i]=Integer.parseInt(st.nextToken());
        }

        cal(arr[0],1);
        System.out.println(max);
        System.out.println(min);

    }

    public static void cal(int result, int idx){

        if(idx==N){
            min=Math.min(result,min);
            max=Math.max(result,max);
            return;
        }

        for(int i=0;i<4;i++){
            if(op[i]>0){
                op[i]--;
                if(i==0){
                    cal(result+arr[idx],idx+1);
                }
                else if(i==1){
                    cal(result-arr[idx],idx+1);
                }
                else if(i==2){
                    cal(result*arr[idx],idx+1);
                }
                else {
                    cal(result/arr[idx],idx+1);
                }
                op[i]++;
            }
        }
    }
}
