package BAEKJOON.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        int arr[]=new int[T];
        int coin[]={25,10,5,1};
        int result[][]=new int[T][4];

        for(int i=0;i<T;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0;i<T;i++){
            int value=arr[i];
            for(int j=0;j<coin.length;j++){
                if(value>=coin[j]){
                    result[i][j]=value/coin[j];
                    value=value%coin[j];
                }
            }
        }

        for(int i=0;i<T;i++){
            for(int j=0;j<4;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}
