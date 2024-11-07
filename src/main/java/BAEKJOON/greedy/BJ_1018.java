package BAEKJOON.greedy;
import java.io.*;
import java.util.*;

public class BJ_1018 {

    static int N,M;
    static char arr[][];
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new char[N][M];

        for(int i=0;i<N;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j);
            }
        }

        // black 시작
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                min=Math.min(min,checkMin(i,j));
            }
        }
        System.out.println(min);

    }

    // Black을 시작으로 세팅, 나머지 값들은 White
    public static int checkMin(int r, int c){

        int count=0;
        char start='B';
        for(int i=r;i<r+8;i++){
            for(int j=c;j<c+8;j++){
                if(arr[i][j]!=start) count++;
                if(start=='B'){
                    start='W';
                } else {
                    start='B';
                }
            }
            if(start=='B'){
                start='W';
            } else {
                start='B';
            }
        }
        count=Math.min(count,64-count);
        return count;
    }
}
