import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        Queue<String> one_que=new LinkedList<>();
        Queue<String> two_que=new LinkedList<>();

        for(int i=0;i<N;i++){
            String s=br.readLine();
            one_que.add(s);
        }

        for(int i=0;i<N;i++){
            String s=br.readLine();
            two_que.add(s);
        }

        int count=0;

        while(!two_que.isEmpty()){
            String s=two_que.poll();
            if(!one_que.peek().equals(s)){
                count++;
                one_que.remove(s);
            }
            else {
                one_que.poll();
            }
        }

        System.out.println(count);
    }
}