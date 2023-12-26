package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        while(T-->0) {
            int N=Integer.parseInt(br.readLine());
            int arr[][]=new int[N][2];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // 서류
                arr[i][1] = Integer.parseInt(st.nextToken()); // 면접
            }

            Arrays.sort(arr,new Comparator<int[]>(){ // 서류점수 오름차순

                public int compare(int n1[], int n2[]){
                    if(n1[0]>n2[0]){
                        return 1;
                    }
                    return -1;
                }
            });

            int value=arr[0][1]; // 면접시험 점수
            int count=1;
            for(int i=1;i<arr.length;i++){
                if(arr[i][1]<value){
                    value=arr[i][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
