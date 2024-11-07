package BAEKJOON.columbus_study_6th.week3;
import java.io.*;
import java.util.*;

public class BJ_1874 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        Stack<Integer> stack=new Stack<>();

        int start=0;
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(br.readLine());

            if(num>start){
                for(int j=start+1;j<=num;j++){
                    sb.append('+'+"\n");
                    stack.push(j);
                    start++;
                }
            }
            else if(stack.peek()!=num){
                System.out.println("NO");
                return;
            }
            sb.append('-'+"\n");
            stack.pop();
        }
        System.out.println(sb);
    }
}
