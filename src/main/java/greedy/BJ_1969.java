package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1969 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        String s[]=new String[N];
        String result="";

        for(int i=0;i<N;i++){
            s[i]=br.readLine();
        }

        for(int i=0;i<M;i++){
            int dna[]=new int[4]; // A,C,G,T
            int max=0;
            for(int j=0;j<N;j++){
                char ch=s[j].charAt(i);
                if(ch=='A') dna[0]++;
                else if(ch=='C') dna[1]++;
                else if(ch=='G') dna[2]++;
                else dna[3]++;
            }
            for(int j=0;j<4;j++){
                if(max<dna[j]) max=dna[j];
            }
            for(int j=0;j<4;j++){
                if(max==dna[j]){
                    if(j==0) result+="A";
                    else if(j==1) result+="C";
                    else if(j==2) result+="G";
                    else result+="T";
                    break;
                }
            }
        }

        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(result.charAt(j)!=s[i].charAt(j)) count++;
            }
        }
        System.out.println(result);
        System.out.println(count);
    }
}
