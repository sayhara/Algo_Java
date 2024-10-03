package greedy;
import java.io.*;
import java.util.*;

public class BJ_1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        String s[]=new String[N];

        for(int i=0;i<N;i++){
            s[i]=br.readLine();
        }

        Arrays.sort(s, new Comparator<String>() {

            public int compare(String s1, String s2){
                if(s1.length()>s2.length()){
                    return 1;
                } else if(s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }
                return -1;
            }
        });

        ArrayList<String> list=new ArrayList<>();

        for(int i=0;i<N;i++){
            if(list.contains(s[i])) continue;
            else list.add(s[i]);
        }

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
