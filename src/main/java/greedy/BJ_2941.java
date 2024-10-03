package greedy;
import java.io.*;

public class BJ_2941 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        String arr[]={"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(int i=0;i<arr.length;i++){
            s=s.replaceAll(arr[i],"H");
        }

        System.out.println(s.length());

    }
}
