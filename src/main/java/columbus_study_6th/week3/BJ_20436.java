package columbus_study_6th.week3;
import java.io.*;
import java.util.*;

public class BJ_20436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        char ch[][]={{'q','w','e','r','t','y','u','i','o','p'},
                        {'a','s','d','f','g','h','j','k','l'},
                        {'z','x','c','v','b','n','m'}};
        System.out.println(ch.length+" "+ch[0].length);
        int l_pos[]=new int[2];
        int r_pos[]=new int[2];

        String l=st.nextToken();
        Loop:
        for(int i=0;i<ch.length;i++){
            for(int j=0;j<ch[i].length;j++){
                if(l.equals(ch[i][j]+"")){
                    l_pos[0]=i;
                    l_pos[1]=j;
                    break Loop;
                }
            }
        }

        String r=st.nextToken();
        Loop:
        for(int i=0;i<ch.length;i++){
            for(int j=0;j<ch[i].length;j++){
                if(r.equals(ch[i][j]+"")){
                    r_pos[0]=i;
                    r_pos[1]=j;
                    break Loop;
                }
            }
        }

        String s=br.readLine();

        int leftSum=0;
        int rightSum=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            for(int j=0;j<ch.length;j++){
                for(int k=0;k<ch[j].length;k++){
                    if(c=='y' || c=='u' || c=='i' || c=='o' || c=='p'
                            || c=='h' || c=='j' || c=='k' || c=='l' || c=='b' || c=='n' || c=='m'){
                        rightSum++;
                        rightSum+=Math.abs(r_pos[0]-j)+Math.abs(r_pos[1]-k);
                        r_pos[0]=j; r_pos[1]=k;
                        System.out.println(rightSum);
                    }
                    else {
                        leftSum++;
                        leftSum+=Math.abs(l_pos[0]-j)+Math.abs(l_pos[1]-k);
                        l_pos[0]=j; l_pos[1]=k;
                    }
                }
            }
        }
        System.out.println(leftSum+rightSum);
    }
}
