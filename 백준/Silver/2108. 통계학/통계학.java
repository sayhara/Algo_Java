import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int arr[]=new int[N];
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            sum+=arr[i];
        }

        Arrays.sort(arr);

        int cnt=0;
        for(int num:map.keySet()){
            if(map.get(num)>cnt) cnt=map.get(num);
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int num:map.keySet()){
            if(map.get(num)==cnt){
                list.add(num);
            }
        }

        int maxValue=0;
        Collections.sort(list);
        if(list.size()>1){
            maxValue=list.get(1);
        } else {
            maxValue=list.get(0);
        }

        String result=String.format("%.0f",(double)sum/N);
        if(result.equals("-0")) result="0";
        System.out.println(result);
        System.out.println(arr[N/2]);
        System.out.println(maxValue);
        System.out.println(arr[N-1]-arr[0]);

    }
}