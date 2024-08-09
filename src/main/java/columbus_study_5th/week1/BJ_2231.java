package columbus_study_5th.week1;
import java.io.*;

public class BJ_2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        for(int i=1;i<=1000000;i++){
            if(check(i)==N){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

    }

    public static int check(int num){

        int sum=num;
        while(num>0){
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
}
