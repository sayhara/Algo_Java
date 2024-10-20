import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set=new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int arr[]=new int[N];
        boolean visited[]=new boolean[N];
        int output[]=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(arr,output,visited,0,M);

        for(String s:set){
            System.out.println(s);
        }

    }

    public static void dfs(int arr[], int output[], boolean visited[], int depth, int r){

        if(depth==r){
            String s="";
            for(int i=0;i<r;i++){
                s+=output[i]+" ";
            }
            set.add(s);
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                dfs(arr,output,visited,depth+1,r);
                visited[i]=false;
            }
        }
    }
}