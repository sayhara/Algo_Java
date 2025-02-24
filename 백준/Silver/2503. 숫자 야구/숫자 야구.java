import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int arr[][]=new int[N][3];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            arr[i][2]=Integer.parseInt(st.nextToken());
        }

        int count=0;
        for(int num=123;num<=987;num++) {
            boolean chk = true;
            if (chkDiff(num)) {
                // 각 케이스별 strike, ball 개수 체크
                for (int i = 0; i < N; i++) {
                    String s1 = Integer.toString(num);
                    String s2 = Integer.toString(arr[i][0]);
                    int strike = 0, ball = 0;
                    for (int j = 0; j < s1.length(); j++) {
                        if (s1.charAt(j) == s2.charAt(j)) strike++;
                    }
                    for (int j = 0; j < s1.length(); j++) {
                        for (int k = 0; k < s2.length(); k++) {
                            if (j == k) continue;
                            if (s1.charAt(j) == s2.charAt(k)) ball++;
                        }
                    }
                    // 한번이라도 일치하지 않은 경우 체크
                    if (strike != arr[i][1] || ball != arr[i][2]) {
                        chk = false;
                        break;
                    }
                }
                if (chk) count++;
            }
        }
        System.out.println(count);
    }

    // 값이 서로 다른 수 체크
    public static boolean chkDiff(int num){
        
        char first=Integer.toString(num).charAt(0);
        char second=Integer.toString(num).charAt(1);
        char third=Integer.toString(num).charAt(2);

        if(first==second || first==third || second==third){
            return false;
        }

        if(first=='0' || second=='0' || third=='0'){
            return false;
        }
        return true;
    }
}