package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5585 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int remain=1000-num;
        int cnt=0;
        int arr[]={500,100,50,10,5,1};

        for(int i=0;i<arr.length;i++){
            if(remain>=arr[i]){
                cnt+=remain/arr[i];
                remain=remain%arr[i];
            }
        }
        System.out.println(cnt);
    }
}
