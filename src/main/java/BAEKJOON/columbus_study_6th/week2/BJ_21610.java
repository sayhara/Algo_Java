package BAEKJOON.columbus_study_6th.week2;
import java.io.*;
import java.util.*;

public class BJ_21610 {

    static int N,M;
    static int map[][];
    static boolean cloud[][], copy_cloud[][];
    // 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int dr[]={0,0,-1,-1,-1,0,1,1,1};
    static int dc[]={0,-1,-1,0,1,1,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][N]; // 물의 양
        cloud=new boolean[N][N]; // 이동시켜야 하는 구름 위치
        copy_cloud=new boolean[N][N]; // 3에서 사라진 구름 위치

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        // 비바라기 시전
        cloud[N-1][0]=true;
        cloud[N-1][1]=true;
        cloud[N-2][0]=true;
        cloud[N-2][1]=true;

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int d=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());

            // 1. 구름이동
            moveCloud(d,s);
            // 2. 물복사버그 시전
            updateDiagonal();
            // 3. 물의 양 체크
            checkWater();
        }

        sum();
    }

    public static void moveCloud(int d, int s){

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++) {
                if (cloud[r][c]) {
                    int nr = (r + (dr[d] + N) * s) % N;
                    int nc = (c + (dc[d] + N) * s) % N;

                    map[nr][nc]++;
                    copy_cloud[nr][nc] = true;
                    cloud[r][c] = false; // 구름 이동 시킨 후 사라짐
                }
            }
        }
    }

    public static void updateDiagonal(){

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(copy_cloud[r][c]) { // 물이 증가한 칸
                    for (int d = 2; d <= 8; d += 2) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] != 0) {
                            map[r][c]++;
                        }
                    }
                }
            }
        }
    }

    public static void checkWater(){

        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(!copy_cloud[r][c] && map[r][c]>=2){
                    map[r][c]-=2;
                    cloud[r][c]=true; // 구름 생성
                }
                else if(copy_cloud[r][c]) copy_cloud[r][c]=false; // 구름 위치 지워짐
            }
        }
    }

    public static void sum(){

        int answer=0;
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                answer+=map[r][c];
            }
        }
        System.out.println(answer);
    }

}
