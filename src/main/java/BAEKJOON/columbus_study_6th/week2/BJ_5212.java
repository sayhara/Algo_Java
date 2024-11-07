package BAEKJOON.columbus_study_6th.week2;
import java.io.*;
import java.util.*;

public class BJ_5212 {

    static int R,C;
    static char ch[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int maxR=0,minR=10,maxC=0,minC=10;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        ch=new char[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                ch[i][j]=s.charAt(j);
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(ch[i][j]=='X') check(i,j);
            }
        }

        for(int i=minR;i<=maxR;i++){
            for(int j=minC;j<=maxC;j++){
                if(ch[i][j]=='X'){
                    System.out.print(ch[i][j]);
                } else {
                    System.out.print('.');
                }
            }
            System.out.println();
        }

    }

    public static void check(int r, int c){

        int count=0;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr<0 || nc<0 || nr>=R || nc>=C || ch[nr][nc]=='.') count++;
        }
        if(count>=3) ch[r][c]='O';

        if(ch[r][c]=='X'){
            maxR=Math.max(maxR,r);
            minR=Math.min(minR,r);
            maxC=Math.max(maxC,c);
            minC=Math.min(minC,c);
        }
    }
}
