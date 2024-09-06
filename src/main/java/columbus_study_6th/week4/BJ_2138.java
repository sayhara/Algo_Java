package columbus_study_6th.week4;
import java.io.*;
import java.util.*;

public class BJ_2138 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        char c1[]=br.readLine().toCharArray();
        char c2[]=br.readLine().toCharArray();

        for(int i=0;i<c1.length;i++){
            if(c1[i]!=c2[i]){
                checkValue();
            }
        }

    }

    public static void checkValue(){



    }
}
