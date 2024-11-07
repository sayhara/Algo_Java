package BAEKJOON.search;
import java.io.*;
import java.util.*;

// result 배열 필요없이 visited 여부로 체크 가능
public class BJ_1759 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int L=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());
        String s[]=new String[C];
        boolean visited[]=new boolean[C];
        String result[]=new String[C];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            s[i]=st.nextToken();
        }
        Arrays.sort(s);
        combination(s,visited,result,0,0,L);

    }

    public static void combination(String s[], boolean visited[], String result[], int start, int depth, int r){

        if(depth==r){
            check(result,r);
            return;
        }

        for(int i=start;i<s.length;i++){
            if(!visited[i]){
                visited[i]=true;
                result[depth]=s[i];
                combination(s,visited,result,i+1,depth+1,r);
                visited[i]=false;
            }
        }
    }

    public static void check(String result[], int r){

        int mo=0,ja=0;
        String answer="";
        for(int i=0;i<r;i++){
            char ch = result[i].charAt(0);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') mo++;
            else ja++;
            answer+=result[i];
        }

        if(mo>=1 && ja>=2){
            System.out.println(answer);
        }
    }
}
