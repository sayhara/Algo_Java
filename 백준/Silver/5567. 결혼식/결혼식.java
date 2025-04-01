import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int count=0;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine()); // 동기의 수
        m=Integer.parseInt(br.readLine()); // 리스트의 길이
        visited=new boolean[n+1];
        list=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a1=Integer.parseInt(st.nextToken());
            int b1=Integer.parseInt(st.nextToken());
            list[a1].add(b1);
            list[b1].add(a1);
        }

        check(1);
        System.out.println(count);

    }

    public static void check(int start){

        Queue<Node> q=new LinkedList<>();
        q.add(new Node(start,0));

        while(!q.isEmpty()){
            Node curNode = q.poll();

            if(curNode.cnt==2){
                for(int i=2;i<=n;i++){
                    if(visited[i]){
                        count++;
                    }
                }
                return;
            }

            for(int value:list[curNode.num]){
                if(!visited[value]){
                    visited[value]=true;
                    q.add(new Node(value, curNode.cnt+1));
                }
            }
        }
    }

    public static class Node {

        int num;
        int cnt;

        public Node(int num, int cnt){
            this.num=num;
            this.cnt=cnt;
        }
    }
}