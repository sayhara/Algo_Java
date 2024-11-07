package BAEKJOON.search;
import java.io.*;
import java.util.*;

public class BJ_2503 {

    static int N;
    static int list[][];
    static ArrayList<Integer> result=new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        list=new int[N][3];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            list[i][0]=Integer.parseInt(st.nextToken());
            list[i][1]=Integer.parseInt(st.nextToken());
            list[i][2]=Integer.parseInt(st.nextToken());
        }

        check();
        System.out.println(result.size());

    }

    public static void check(){

        for(int num=123;num<=987;num++){
            if(!checkNumber(num)) continue;
            boolean chk=true;

            for(int i=0;i<N;i++){
                int strike=0, ball=0;
                String n1=Integer.toString(num);
                String n2=Integer.toString(list[i][0]);

                for(int j=0;j<3;j++){
                    if(n1.charAt(j)==n2.charAt(j)) strike++;
                }

                for(int j=0;j<3;j++){
                    for(int k=0;k<3;k++){
                        if(j==k) continue;
                        if(n1.charAt(j)==n2.charAt(k)) ball++;
                    }
                }
                if(strike!=list[i][1] || ball!=list[i][2]){
                    chk=false;
                    break;
                }
            }
            if(chk){
                result.add(num);
            }
        }
    }

    public static boolean checkNumber(int num){

        char first=Integer.toString(num).charAt(0);
        char second=Integer.toString(num).charAt(1);
        char third=Integer.toString(num).charAt(2);

        if(first==second || first==third || second==third){
            return false;
        }

        if(first=='0' || second=='0' || third=='0'){
            return false;
        }
        return true;
    }
}
