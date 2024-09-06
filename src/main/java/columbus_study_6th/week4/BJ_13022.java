package columbus_study_6th.week4;

import java.io.*;
import java.util.*;

public class BJ_13022 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        boolean chk=false;
        if(s.charAt(0)!='w'){
            System.out.println(0);
            return;
        }
        int wCnt=1, oCnt=0, lCnt=0, fCnt=0;

        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='w'){
                wCnt++;
            }
            else if(ch=='o'){
                oCnt++;
            }
            else if(ch=='l'){
                lCnt++;
            }
            else {
                fCnt++;
            }
            // 중간에 wolf 완성됬을 때 판별
            if(i<s.length()-1 && s.charAt(i)=='f' && s.charAt(i+1)=='w'){
                if(!(wCnt==oCnt && oCnt==lCnt && lCnt==fCnt && fCnt==wCnt)){
                    chk=true;
                    break;
                }
            }
        }

        if(!chk && wCnt==oCnt && oCnt==lCnt && lCnt==fCnt && fCnt==wCnt){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
