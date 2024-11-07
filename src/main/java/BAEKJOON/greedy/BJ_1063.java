package BAEKJOON.greedy;

import java.io.*;
import java.util.*;

public class BJ_1063 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        char king[]=st.nextToken().toCharArray();
        char stone[]=st.nextToken().toCharArray();
        int N=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            String line=br.readLine();
            char king_pos[]=king.clone();
            char stone_pos[]=stone.clone();
            move(line,king_pos);
            if(range(king_pos)) continue;
            if(Arrays.equals(king_pos,stone_pos)){
                move(line,stone_pos);
                if(range(stone_pos)) continue;
            }

            king=king_pos;
            stone=stone_pos;
        }

        System.out.println(king);
        System.out.println(stone);
    }

    public static void move(String line, char[] next){

        switch (line){
            case "R": next[0]++; break;
            case "L": next[0]--; break;
            case "B": next[1]--; break;
            case "T": next[1]++; break;
            case "RT": next[0]++; next[1]++; break;
            case "LT": next[0]--; next[1]++; break;
            case "RB": next[0]++; next[1]--; break;
            case "LB": next[0]--; next[1]--; break;
        }
    }

    public static boolean range(char[] next){
        return (next[0]<'A' || next[0]>'H' || next[1]<'1' || next[1]>'8');
    }
}
