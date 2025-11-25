import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String[] minus_split=line.split("\\-");
        ArrayList<Integer> list=new ArrayList<>();

        for(String s:minus_split){
            if(s.contains("+")){
                String[] plus_split=s.split("\\+");
                int sum=0;
                for(String num:plus_split){
                    sum+=Integer.parseInt(num);
                }
                list.add(sum);
            } else {
                list.add(Integer.parseInt(s));
            }
        }

        int result=list.get(0);
        for(int i=1;i<list.size();i++){
            result-=list.get(i);
        }
        System.out.println(result);

    }
}
