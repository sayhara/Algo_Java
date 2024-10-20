package data_structure;
import java.io.*;
import java.util.*;

public class BJ_4949 {

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String s=br.readLine();

            if(s.equals(".")) break;
            Stack<Character> stack=new Stack<>();

            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);

                if(ch=='(' || ch=='['){
                    stack.add(ch);
                }

                else if(ch==')'){
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();
                    }
                    else {
                        stack.add(ch);
                    }
                }

                else if(ch==']'){
                    if(!stack.isEmpty() && stack.peek()=='['){
                        stack.pop();
                    }
                    else {
                        stack.add(ch);
                    }
                }
            }

            if(stack.isEmpty()) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}
