package BAEKJOON.data_structure;
import java.io.*;
import java.util.*;

public class BJ_9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            String s=br.readLine();
            Stack<Character> stack=new Stack<>();
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='('){
                    stack.add('(');
                }
                else if(s.charAt(j)==')'){
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }
                    else {
                        stack.add(')');
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);

    }
}
