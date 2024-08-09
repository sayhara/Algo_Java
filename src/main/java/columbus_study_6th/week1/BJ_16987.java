package columbus_study_6th.week1;
import java.io.*;
import java.util.*;

public class BJ_16987 {

    static int N;
    static int arr[][];
    static int result=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        System.out.println(result);

    }

    public static void dfs(int start, int cnt){

        result=Math.max(result,cnt);
        if(start==N) return;
        if(arr[start][0]<=0){
            dfs(start+1,cnt);
        } else {
            for(int i=0;i<N;i++){
                if(i==start || arr[i][0]<=0) continue;

                arr[start][0]-=arr[i][1];
                arr[i][0]-=arr[start][1];

                int cnt_add=cnt;
                if(arr[start][0]<=0) cnt_add++;
                if(arr[i][0]<=0) cnt_add++;

                dfs(start+1,cnt_add);

                arr[start][0]+=arr[i][1];
                arr[i][0]+=arr[start][1];

            }
        }
    }
}
