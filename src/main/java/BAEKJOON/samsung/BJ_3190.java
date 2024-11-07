package BAEKJOON.samsung;
import java.io.*;
import java.util.*;

public class BJ_3190 {

    static int N,K;
    static int arr[][];
    static HashMap<Integer,String> hash=new HashMap<>();
    static List<int[]> snake=new LinkedList<>();
    static int dr[]={0,1,0,-1};
    static int dc[]={1,0,-1,0}; // 동->남->서->북
    static int time=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        K=Integer.parseInt(br.readLine());
        arr=new int[N][N];

        StringTokenizer st;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken())-1;
            arr[r][c]=1; // 사과의 위치
        }

        int L=Integer.parseInt(br.readLine());
        for(int i=0;i<L;i++){
            st=new StringTokenizer(br.readLine());
            int X=Integer.parseInt(st.nextToken());
            String C=st.nextToken();
            hash.put(X,C);
        }

        solve();
        System.out.println(time);

    }

    public static void solve(){

        int r=0, c=0; // 초기 좌표
        int d=0; // 초기 방향
        snake.add(new int[]{0,0});

        while(true){

            time++;
            int nr=r+dr[d];
            int nc=c+dc[d];

            if(!check(nr,nc)) break;

            snake.add(new int[]{nr,nc});
            if(arr[nr][nc]==1){
                arr[nr][nc]=0;
            } else {
                snake.remove(0);
            }

            if(hash.containsKey(time)){
                String s = hash.get(time);
                if(s.equals("L")){
                    d=(d-1)==-1?3:d-1;
                }
                else {
                    d=(d+1)==4?0:d+1;
                }
            }
            r=nr;
            c=nc;
        }
    }

    public static boolean check(int nr, int nc){

        if(nr<0 || nc<0 || nr>=N || nc>=N){
            return false;
        }

        for(int i=0;i<snake.size();i++){
            int r=snake.get(i)[0];
            int c=snake.get(i)[1];
            if(r==nr && c==nc){
                return false;
            }
        }
        return true;
    }

}
