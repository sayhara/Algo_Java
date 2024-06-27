package search;
import java.io.*;
import java.util.*;

public class BJ_4179 {

    static int R,C;
    static char ch[][];
    static Queue<Node> person=new LinkedList<>();
    static Queue<Node> fire=new LinkedList<>();
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};

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
                if(ch[i][j]=='J') person.add(new Node(i,j,0));
                else if(ch[i][j]=='F') fire.add(new Node(i,j,0));
            }
        }

        bfs();

    }

    public static void bfs(){

        while(!person.isEmpty()){

            int f_size=fire.size();
            for(int i=0;i<f_size;i++){

                Node curFire=fire.poll();

                for(int d=0;d<4;d++){
                    int nr=curFire.r+dr[d];
                    int nc=curFire.c+dc[d];

                    if(nr>=0 && nc>=0 && nr<R && nc<C){
                        if(ch[nr][nc]=='J' || ch[nr][nc]=='.'){
                            ch[nr][nc]='F';
                            fire.add(new Node(nr,nc,curFire.cnt+1));
                        }
                    }
                }
            }

            int p_size=person.size();
            for(int i=0;i<p_size;i++){

                Node curPerson=person.poll();
                if(curPerson.r==0 || curPerson.r==R-1 || curPerson.c==0 || curPerson.c==C-1){
                    System.out.println(curPerson.cnt+1);
                    return;
                }

                for(int d=0;d<4;d++){
                    int nr=curPerson.r+dr[d];
                    int nc=curPerson.c+dc[d];

                    if(nr>=0 && nc>=0 && nr<R && nc<C){
                        if(ch[nr][nc]=='.'){
                            ch[nr][nc]='J';
                            person.add(new Node(nr,nc,curPerson.cnt+1));
                        }
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    public static class Node {

        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt){
            this.r=r;
            this.c=c;
            this.cnt=cnt;
        }
    }
}
