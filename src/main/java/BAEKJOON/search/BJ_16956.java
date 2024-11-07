package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_16956 {

    static int R,C;
    static char[][] ch;
    static Queue<int[]> q=new LinkedList<>();
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static boolean chk=true;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        ch=new char[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<C;j++){
                ch[i][j]=s.charAt(j);
                if(ch[i][j]=='W') q.add(new int[]{i,j});
            }
        }

        bfs();

        if(chk) {
            System.out.println(1);
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    System.out.print(ch[i][j] + "");
                }
                System.out.println();
            }
        } else {
            System.out.println(0);
        }

    }

    public static void bfs(){

        while(!q.isEmpty()){

            int now[]=q.poll();
            for(int i=0;i<4;i++){
                int nr=now[0]+dr[i];
                int nc=now[1]+dc[i];

                if(nr>=0 && nc>=0 && nr<R && nc<C){
                    if(ch[nr][nc]=='.'){
                        ch[nr][nc]='D';
                    }
                    if(ch[nr][nc]=='S'){
                        chk=false;
                        return;
                    }
                }
            }
        }
    }
}
