package columbus_study_6th.week3;
import java.io.*;

// q,u,a,c,k가 나오기 전에는 우는 것으로 간주 x
public class BJ_12933 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        char s[]=br.readLine().toCharArray();
        char duck[]={'q','u','a','c','k'};

        if(s.length%5!=0){
            System.out.println(-1);
            return;
        }

        int total=s.length;
        int idx=0;
        int result=0;

        while(true){

            int ptr=0; // 울음소리 count
            int temp[]=new int[5];
            int tid=0;
            boolean chk=false;

            for(int i=0;i<s.length;i++){ // 올바른 울음소리인 경우마다 초기화
                if(s[i]==duck[ptr]){
                    temp[tid++]=i;
                    ptr++;
                }

                if(ptr==5){
                    chk=true;
                    ptr=0;
                    tid=0;
                    total-=5;
                    for(int j=0;j<5;j++){
                        s[temp[j]]='.';
                    }
                }
            }
            if(chk) result++;
            else {
                System.out.println(-1);
                return;
            }
            if(total==0) break;
        }
        System.out.println(result);
    }
}
