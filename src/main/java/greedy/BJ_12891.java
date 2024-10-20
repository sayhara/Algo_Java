package greedy;
import java.io.*;
import java.util.*;

public class BJ_12891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int S=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());

        String s=br.readLine();
        int dna[]=new int[4]; // A C G T
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            dna[i]=Integer.parseInt(st.nextToken());
        }

        int result=0;
        int aCnt=0, cCnt=0, gCnt=0, tCnt=0;

        for(int i=0;i<P;i++){
            char ch=s.charAt(i);
            if(ch=='A') aCnt++;
            else if(ch=='C') cCnt++;
            else if(ch=='G') gCnt++;
            else tCnt++;
        }
        if(dna[0]<=aCnt && dna[1]<=cCnt && dna[2]<=gCnt && dna[3]<=tCnt) result++;

        for(int i=P;i<S;i++){

            char ch2=s.charAt(i-P);
            if(ch2=='A') aCnt--;
            else if(ch2=='C') cCnt--;
            else if(ch2=='G') gCnt--;
            else if(ch2=='T') tCnt--;

            char ch1=s.charAt(i);
            if(ch1=='A') aCnt++;
            else if(ch1=='C') cCnt++;
            else if(ch1=='G') gCnt++;
            else if(ch1=='T') tCnt++;

            if(dna[0]<=aCnt && dna[1]<=cCnt && dna[2]<=gCnt && dna[3]<=tCnt) result++;

        }

        System.out.println(result);

    }
}
