package search;
import java.io.*;
import java.util.*;

public class BJ_7562 {

    static int dr[]={-2,-1,1,2,2,1,-1,-2};
    static int dc[]={1,2,2,1,-1,-2,-2,-1};
    static int l;
    static int arr[][];
    static boolean visited[][];
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            l=Integer.parseInt(br.readLine()); // 한변의 길이
            arr=new int[l][l];
            visited=new boolean[l][l];

            StringTokenizer st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine());
            int nr=Integer.parseInt(st.nextToken());
            int nc=Integer.parseInt(st.nextToken());

            BFS(r,c,nr,nc);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void BFS(int br, int bc, int ar, int ac){

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{br,bc});
        visited[br][bc]=true;

        while(!q.isEmpty()){

            int[] now = q.poll();
            int r=now[0];
            int c=now[1];

            if(r==ar && c==ac){
                sb.append(arr[r][c]);
                break;
            }

            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nc>=0 && nr<l && nc<l){
                    if(!visited[nr][nc]){
                        arr[nr][nc]=arr[r][c]+1;
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}
