package IT_Prob;
import java.io.*;

public class BJ_9655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        if(N%2==1){
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
