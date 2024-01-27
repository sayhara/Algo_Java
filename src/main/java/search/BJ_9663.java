package search;
import java.io.*;
import java.util.*;

// N-Queen
public class BJ_9663 {

    static int N;
    static int arr[];
    static int cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        nQueen(0);
        System.out.println(cnt);
    }

    public static void nQueen(int depth){

        if(depth==N){
            cnt++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[depth]=i;
            if(check(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean check(int depth){

        for(int i=0;i<depth;i++){ // 각 열마다 하나의 값
            if(arr[depth]==arr[i]){
                return false;
            }

            else if(Math.abs(arr[depth]-arr[i])==Math.abs(depth-i)){
                return false;
            }
        }
        return true;

    }
}
