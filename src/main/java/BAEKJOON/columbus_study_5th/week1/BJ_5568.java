package BAEKJOON.columbus_study_5th.week1;
import java.io.*;
import java.util.*;

public class BJ_5568 {

    static int n,k;
    static String card[];
    static boolean use[];
    static Set<String> result=new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());
        card=new String[n];
        use=new boolean[n];

        for(int i=0;i<n;i++){
            card[i]=br.readLine();
        }

        make("",0);
        System.out.println(result.size());

    }

    public static void make(String s, int cnt){

        if(cnt==k){
            result.add(s);
            return;
        }

        for(int i=0;i<n;i++){
            if(!use[i]){
                use[i]=true;
                make(s+card[i],cnt+1);
                use[i]=false;
            }
        }
    }
}
