package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_1744 {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        ArrayList<Integer> minus=new ArrayList<>();
        ArrayList<Integer> plus=new ArrayList<>();
        ArrayList<Integer> remain=new ArrayList<>();

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            if(arr[i]>0) plus.add(arr[i]);
            else minus.add(arr[i]);
        }
        Collections.sort(minus);
        Collections.sort(plus, Collections.reverseOrder());
        int sum=0;

        while(minus.size()>0){
            if(minus.size()>=2) {
                sum += Math.max(minus.get(0) * minus.get(1), minus.get(0)+minus.get(1));
                minus.remove(0);
                minus.remove(0);
            }
            else if(minus.size()==1) {
                remain.add(minus.get(0));
                minus.remove(0);
            }
        }

        while(plus.size()>0){
            if(plus.size()>=2) {
                sum += Math.max(plus.get(0) * plus.get(1),plus.get(0)+plus.get(1));
                plus.remove(0);
                plus.remove(0);
            }
            else if(plus.size()==1){
                remain.add(plus.get(0));
                plus.remove(0);
            }
        }

        for(int i=0;i<remain.size();i++){
            sum+=remain.get(i);
        }
        System.out.println(sum);

    }
}
