package search;
import java.io.*;
import java.util.*;

public class BJ_10815 {

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M=Integer.parseInt(br.readLine());
        int arr2[]=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            search(arr,arr2[i]);
        }
        System.out.println(sb.toString());

    }

    public static void search(int arr[], int value){

        int left=0;
        int right=arr.length-1;
        int mid;

        while(left<=right){
            mid=(left+right)/2;

            if(arr[mid]==value){
                sb.append(1+" ");
                return;
            }
            else if(arr[mid]<value){
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        sb.append(0+" ");
    }
}
