package columbus_study_5th.week1;
import java.io.*;

public class BJ_25501 {

    static StringBuilder sb=new StringBuilder();
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            String s=br.readLine();
            cnt=0;
            sb.append(isPalindrome(s)+" "+cnt+"\n");
        }
        System.out.println(sb.toString());

    }

    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
