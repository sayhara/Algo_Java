import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        // 누적 합 최소를 위한 오름차순 정렬
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=arr[i]*(N-i);
        }
        System.out.println(sum);

    }
}