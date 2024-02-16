package search;
import java.io.*;
import java.util.*;

public class BJ_1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int A[]=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M=Integer.parseInt(br.readLine());
        int B[]=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            B[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            search(A,B[i]);
        }
    }

    public static void search(int arr[], int target){

        int left=0;
        int right=arr.length-1;
        int mid;

        while(left<=right){
            mid=(left+right)/2;

            if(arr[mid]==target){
                System.out.println(1);
                return;
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        System.out.println(0);
    }
}
