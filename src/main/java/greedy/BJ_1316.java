package greedy;
import java.io.*;
import java.util.*;

public class BJ_1316 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        int count=0;
        for(int i=0;i<N;i++){
            String s=br.readLine();
            if(check(s)) count++;
        }
        System.out.println(count);

    }

    public static boolean check(String s){

        ArrayList<Character> list=new ArrayList<>();
        list.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
            else if(list.contains(s.charAt(i)) && s.charAt(i)==s.charAt(i-1)) continue;
            else {
                return false;
            }
        }
        return true;
    }
}
