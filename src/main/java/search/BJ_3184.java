package search;

import java.io.*;
import java.util.*;

public class BJ_3184 {

    static int R,C;
    static char ch[][];
    static boolean visited[][];
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
    static int v_res=0, o_res=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        ch=new char[R][C];
        visited=new boolean[R][C];

        for(int i=0;i<R;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                ch[i][j]=s.charAt(j);
                if(ch[i][j]=='o') o_res++;
                else if(ch[i][j]=='v') v_res++;
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(ch[i][j]=='v') bfs(i,j);
            }
        }

        System.out.println(o_res+" "+v_res);

    }

    public static void bfs(int r, int c){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c]=true;

        int o_cnt=0, v_cnt=1;
        while(!q.isEmpty()){
            int now[]=q.poll();

            for(int i=0;i<4;i++){
                int nr=now[0]+dr[i];
                int nc=now[1]+dc[i];

                if(nr<0 || nc<0 || nr>=R || nc>=C || visited[nr][nc]) continue;
                if(ch[nr][nc]!='#'){
                    if(ch[nr][nc]=='o') o_cnt++;
                    else if(ch[nr][nc]=='v') v_cnt++;
                    visited[nr][nc]=true;
                    q.add(new int[]{nr,nc});
                }
            }
        }

        if(o_cnt>v_cnt) v_res-=v_cnt;
        else  o_res-=o_cnt;

    }
}
