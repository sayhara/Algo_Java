package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_1987 {

    static int R,C;
    static int arr[][];
    static boolean alpha[];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int max=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new int[R][C];
        alpha=new boolean[26];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'A';
            }
        }
        DFS(0,0,0);
        System.out.println(max);
    }

    public static void DFS(int r, int c, int cnt){

        if(alpha[arr[r][c]]){
            max=Math.max(max,cnt);
        }
        else {
            alpha[arr[r][c]] = true;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                    DFS(nr, nc, cnt + 1);
                }
            }
            alpha[arr[r][c]]=false;
        }
    }
}
