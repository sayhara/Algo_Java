import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String[] s=new String[N];

        for(int i=0;i<N;i++){
            s[i]=br.readLine();
        }

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2){
                if(s1.length()!=s2.length()){
                    return s1.length()-s2.length();
                }
                else if(s1.length()==s2.length()){
                    return check(s1,s2);
                }
                return -1;
            }
        });

        for(int i=0;i<N;i++){
            System.out.println(s[i]);
        }

    }

    public static int check(String s1, String s2){

        int sum_s1=0;
        int sum_s2=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)>='0' && s1.charAt(i)<='9'){
                sum_s1+=s1.charAt(i)-'0';
            }
        }

        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)>='0' && s2.charAt(i)<='9'){
                sum_s2+=s2.charAt(i)-'0';
            }
        }
        if(sum_s1>sum_s2){
            return 1;
        }
        else if(sum_s1==sum_s2){
            return s1.compareTo(s2);
        } else {
            return -1;
        }
    }
}