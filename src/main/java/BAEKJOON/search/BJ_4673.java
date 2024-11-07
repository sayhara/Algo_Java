package BAEKJOON.search;

public class BJ_4673 {

    public static void main(String[] args) {

        int sum,num;
        boolean check[]=new boolean[10001];

        for(int i=1;i<=10000;i++){
            sum=0;
            num=i;
            sum+=num;
            while(num!=0){
                sum+=num%10;
                num/=10;
            }
            if(sum<=10000) check[sum]=true;
        }

        for(int i=1;i<=10000;i++){
            if(!check[i]){
                System.out.println(i);
            }
        }
    }
}
