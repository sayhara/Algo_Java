package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16953 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Queue<Integer> q=new LinkedList<>();

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        q.add(B);

        int cnt=1;
        while(A<B){
            if(B%2==0){
                B/=2;
            }
            else if(B%10==1){
                B/=10;
            }
            else {
                break;
            }
            q.add(B);
            cnt++;
        }

        StringBuilder sb=new StringBuilder();
        if(A==B){
            sb.append(cnt);
        } else {
            sb.append(-1);
        }
        System.out.println(sb.toString());

    }
}
