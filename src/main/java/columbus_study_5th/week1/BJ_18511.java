package columbus_study_5th.week1;
import java.io.*;
import java.util.*;

public class BJ_18511 {

    static int N,K;
    static int arr[];
    static int ans=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[K];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(ans);

    }

    public static void dfs(int num){

        if(num>N) return;
        if(ans<num) ans=num;

        for(int i=K-1;i>=0;i--){
            dfs(num*10+arr[i]);
        }

    }

}
