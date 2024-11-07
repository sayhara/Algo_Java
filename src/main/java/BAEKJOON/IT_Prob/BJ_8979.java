package BAEKJOON.IT_Prob;
import java.io.*;
import java.util.*;

public class BJ_8979 {

    static int N,K;
    static ArrayList<Node> list=new ArrayList<>();
    static int result=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int num=Integer.parseInt(st.nextToken());
            int gold=Integer.parseInt(st.nextToken());
            int silver=Integer.parseInt(st.nextToken());
            int bronze=Integer.parseInt(st.nextToken());
            list.add(new Node(num,gold,silver,bronze,0));
        }

        Collections.sort(list);
        list.get(0).rank=1;

        for(int i=1;i<list.size();i++){
            Node now=list.get(i);

            int preG=list.get(i-1).gold;
            int preS=list.get(i-1).silver;
            int preB=list.get(i-1).bronze;

            if(list.get(i).num==K){
                result=i;
            }

            if(now.gold==preG && now.silver==preS && now.bronze==preB){
                list.get(i).rank=list.get(i-1).rank;
            } else {
                list.get(i).rank=i+1;
            }
        }

        System.out.println(list.get(result).rank);

    }

    public static class Node implements Comparable<Node>{

        int num,gold,silver,bronze,rank;

        public Node(int num,int gold, int silver, int bronze, int rank){
            this.num=num;
            this.gold=gold;
            this.silver=silver;
            this.bronze=bronze;
            this.rank=rank;
        }

        @Override
        public int compareTo(Node o) {
            if(o.gold==this.gold){
                if(o.silver==this.silver){
                    return o.bronze-this.bronze;
                }
                else {
                    return o.silver-this.silver;
                }
            }
            else {
                return o.gold-this.gold;
            }
        }
    }
}
