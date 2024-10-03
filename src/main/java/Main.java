import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int arr[][];
    static int value=0;

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
        System.out.println(value);

    }

    public static void dfs(int start, int result){

        value=Math.max(value,result);
        if(start==N) return;

        if(arr[start][0]<=0){
            dfs(start+1,result);
        } else {
            for (int i = 0; i < N; i++) {

                if (start == i || arr[i][0] <= 0) continue;

                arr[start][0] -= arr[i][1];
                arr[i][0] -= arr[start][1];

                int cnt = result;
                if (arr[start][0] <= 0) cnt++;
                if (arr[i][0] <= 0) cnt++;

                dfs(start + 1, cnt);

                arr[start][0] += arr[i][1];
                arr[i][0] += arr[start][1];

            }
        }

    }
}