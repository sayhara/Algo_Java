package greedy;
import java.io.*;
import java.util.*;

public class BJ_17413 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        ArrayList<Character> list=new ArrayList<>();
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='<'){
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
                list.add(ch);
                for(int j=i+1;j<s.length();j++){
                    if(s.charAt(j)=='>'){
                        i=j;
                        list.add(s.charAt(j));
                        break;
                    }
                    else {
                        list.add(s.charAt(j));
                    }
                }
            }
            else if(ch==' '){
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }
                list.add(ch);
            }
            else{
                stack.add(ch);
            }
        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
    }

}
