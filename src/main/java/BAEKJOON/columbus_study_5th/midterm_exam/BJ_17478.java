package BAEKJOON.columbus_study_5th.midterm_exam;
import java.io.*;

public class BJ_17478 {

    static String line="";

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        dfs(N,0,"");

    }

    public static void dfs(int N, int start, String line){

        if(start==N){
            System.out.println(line+"\"재귀함수가 뭔가요?\"");
            System.out.println(line+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            while(!line.equals("")){
                System.out.println(line+"라고 답변하였지.");
                line=line.substring(4);
            }
            System.out.println("라고 답변하였지.");
            return;
        }

        System.out.println(line+"\"재귀함수가 뭔가요?\"");
        System.out.println(line+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(line+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(line+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        dfs(N,start+1,line+"____");

    }
}
