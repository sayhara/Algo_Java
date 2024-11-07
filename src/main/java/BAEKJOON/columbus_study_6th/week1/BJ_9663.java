package BAEKJOON.columbus_study_6th.week1;
import java.io.*;

public class BJ_9663 {

    static int N;
    static int arr[];
    static int count=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        nQueen(0);
        System.out.println(count);

    }

    public static void nQueen(int depth){

        if(depth==N){
            count++;
            return;
        }

        for(int i=0;i<N;i++){
            arr[depth]=i; // 열을 변경
            if(check(depth)){
                nQueen(depth+1);
            }
        }
    }

    public static boolean check(int col){

        for(int i=0;i<col;i++){
            if(arr[i]==arr[col]){ // 행이 동일할 때
                return false;
            }
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])){ // 대각선 -> 열의 차 = 행의 차
                return false;
            }
        }
        return true;
    }
}
