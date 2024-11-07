package BAEKJOON.IT_Prob;
import java.io.*;

public class BJ_4659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String s=br.readLine();

            if(s.equals("end")) return;

            boolean answer=false;

            int moCnt=0;
            for(int i=0;i<s.length()-1;i++){
                if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                    moCnt++;
                }
                if(s.charAt(i)==s.charAt(i+1) && s.charAt(i)!='e' && s.charAt(i)!='o'){
                    answer=true;
                    System.out.println("<"+s+">"+ " is not acceptable.");
                }
            }
            if(s.charAt(s.length()-1)=='a' || s.charAt(s.length()-1)=='e' || s.charAt(s.length()-1)=='i' || s.charAt(s.length()-1)=='o' || s.charAt(s.length()-1)=='u'){
                moCnt++;
            }
            if(moCnt==0 && !answer){
                answer=true;
                System.out.println("<"+s+">"+ " is not acceptable.");
            }

            if(s.length()>=3){
                for(int i=0;i<s.length()-2;i++){
                    moCnt=0;
                    for(int j=i;j<i+3;j++) {
                        if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u') {
                            moCnt++;
                        }
                    }
                    if((moCnt==3 || moCnt==0) && !answer){
                        answer=true;
                        System.out.println("<"+s+">"+ " is not acceptable.");
                    }
                }
            }
            if(!answer) System.out.println("<"+s+">"+ " is acceptable.");
        }
    }
}
