package BAEKJOON.samsung;
import java.io.*;
import java.util.*;

public class BJ_14891 {

    static int arr[][];
    static int dir[];

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        arr=new int[4][8];

        for(int i=0;i<4;i++){
            String s=br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j]=s.charAt(j)-'0';
            }
        }

        int k=Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken())-1;
            int d=Integer.parseInt(st.nextToken());
            dir=new int[4];

            dir[num]=d;
            chk(num);
            change();
        }

        int sum=0;
        int value=1;
        for(int i=0;i<4;i++){
            if(arr[i][0]==1) sum+=value;
            value*=2;
        }
        System.out.println(sum);

    }

    public static void chk(int num){

        for(int i=num+1;i<4;i++){
            if(arr[i][6]!=arr[i-1][2]){
                dir[i]=-dir[i-1];
            } else {
                break;
            }
        }

        for(int i=num-1;i>=0;i--){
            if(arr[i][2]!=arr[i+1][6]){
                dir[i]=-dir[i+1];
            } else {
                break;
            }
        }
    }

    public static void change(){

        int temp=0;
        for(int i=0;i<4;i++){
            if(dir[i]==1){ // 시계방향
                temp=arr[i][7];
                for(int j=7;j>0;j--){
                    arr[i][j]=arr[i][j-1];
                }
                arr[i][0]=temp;
            }

            else if(dir[i]==-1){ // 반시계방향
                temp=arr[i][0];
                for(int j=0;j<7;j++){
                    arr[i][j]=arr[i][j+1];
                }
                arr[i][7]=temp;
            }
        }

    }
}
