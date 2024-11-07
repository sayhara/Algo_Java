package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_1806 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        ArrayList<Integer> list=new ArrayList<>();

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int start=0, end=0, sum=0;

        while(true){

            if(sum>=S){
                sum-=arr[start];
                start++;
            }
            else if(end==N){
                break;
            } else {
                sum+=arr[end];
                end++;
            }
            if(sum>=S) list.add(end-start);
        }

        if(list.size()!=0){
            Collections.sort(list);
            System.out.println(list.get(0));
        } else {
            System.out.println(0);
        }

    }

}