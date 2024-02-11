package search;
import java.io.*;
import java.util.*;

public class BJ_2580 {

    static int arr[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr=new int[9][9];

        for(int i=0;i<9;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0,0);

    }

    public static void sudoku(int row, int col){

        if(col==9){
            sudoku(row+1,0);
            return;
        }

        if(row==9){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        if(arr[row][col]==0){
            for(int val=1;val<=9;val++){
                if(check(row,col,val)){
                    arr[row][col]=val;
                    sudoku(row,col+1);
                }
            }
            arr[row][col]=0;    // 다른 케이스 탐색
            return;
        }
        sudoku(row,col+1);

    }

    public static boolean check(int r, int c, int num){

        for(int i=0;i<9;i++){
            if(arr[r][i]==num) return false;
            if(arr[i][c]==num) return false;
        }

        int nr=(r/3)*3;
        int nc=(c/3)*3;

        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(arr[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

}
