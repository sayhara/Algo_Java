import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int tree[]=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            tree[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);

        int left=0;
        int right=tree[N-1];
        int mid;

        while(left<=right){
            mid=(left+right)/2;
            long sum=0;
            for(int i=0;i<N;i++){
                if(tree[i]>mid) sum+=tree[i]-mid;
            }
            if(sum<M){
                right=mid-1;
            } else if(sum>=M){
                left=mid+1;
            }
        }
        System.out.println(right);
    }
}
