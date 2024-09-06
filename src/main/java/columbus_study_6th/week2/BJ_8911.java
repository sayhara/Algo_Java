package columbus_study_6th.week2;
import java.io.*;
import java.util.*;

public class BJ_8911 {

    static int dr[]={0,1,0,-1};
    static int dc[]={1,0,-1,0};
    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());

        while(T-->0){
            String s=br.readLine();
            int x=0,y=0;
            int dir=0; // 북동남서
            ArrayList<Integer> xValue=new ArrayList<>();
            ArrayList<Integer> yValue=new ArrayList<>();
            xValue.add(0);
            yValue.add(0);

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='R'){
                    dir=(dir+1==4)?0:(dir+1);
                }
                else if(s.charAt(i)=='L'){
                    dir=(dir-1==-1)?3:(dir-1);
                }
                else if(s.charAt(i)=='F'){
                    x+=dr[dir];
                    y+=dc[dir];
                    xValue.add(x);
                    yValue.add(y);
                }
                else if(s.charAt(i)=='B'){
                    x-=dr[dir];
                    y-=dc[dir];
                    xValue.add(x);
                    yValue.add(y);
                }
            }

            Collections.sort(xValue);
            Collections.sort(yValue);

            int v=xValue.get(xValue.size()-1)-xValue.get(0);
            int h=yValue.get(yValue.size()-1)-yValue.get(0);
            sb.append(v*h+"\n");
        }
        System.out.println(sb);
    }
}
