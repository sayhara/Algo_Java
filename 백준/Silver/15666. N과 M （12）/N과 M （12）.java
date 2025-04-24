import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int arr[];
    static int output[];
    static ArrayList<String> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        output=new int[M];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0,0);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int depth, int idx){

        if(depth==M){
            String s="";
            for(int i=0;i<M;i++){
                s+=output[i]+" ";
            }
            if(!list.contains(s)){
                list.add(s);
            }
            return;
        }

        for(int i=idx;i<N;i++){
            output[depth]=arr[i];
            dfs(depth+1,i);
        }
    }
}