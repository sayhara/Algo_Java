package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_16234 {

    static int N,L,R;
    static int world[][];
    static boolean visited[][];
    static ArrayList<int[]> list;
    static int sum;
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        world=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                world[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        move();

    }

    public static void move(){

        int count=0;
        while(true){
            visited=new boolean[N][N];
            boolean check=false;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                        if(list.size()>1){
                            change();
                            check=true;
                        }
                    }
                }
            }
            if(!check){
                System.out.println(count);
                return;
            }
            count++;
        }
    }

    public static void bfs(int r, int c){

        Queue<int[]> q=new LinkedList<>();
        list=new ArrayList<>();

        q.add(new int[]{r,c});
        list.add(new int[]{r,c});
        visited[r][c]=true;
        sum=world[r][c];

        while(!q.isEmpty()){

            int now[]=q.poll();
            int br=now[0];
            int bc=now[1];

            for(int i=0;i<4;i++){
                int nr=br+dr[i];
                int nc=bc+dc[i];

                if(nr>=0 && nc>=0 && nr<N && nc<N){
                    if(!visited[nr][nc] && Math.abs(world[nr][nc]-world[br][bc])>=L && Math.abs(world[nr][nc]-world[br][bc])<=R){
                        q.add(new int[]{nr,nc});
                        list.add(new int[]{nr,nc});
                        visited[nr][nc]=true;
                        sum+=world[nr][nc];
                    }
                }
            }
        }
    }

    public static void change(){

        int value=sum/list.size();
        for(int i=0;i<list.size();i++){
            int r=list.get(i)[0];
            int c=list.get(i)[1];
            world[r][c]=value;
        }
    }
}
