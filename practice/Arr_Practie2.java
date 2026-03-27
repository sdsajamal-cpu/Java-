package Basic.practice;

import java.util.Scanner;

public class Arr_Practie2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int []arr = new int[6];
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第"+(i+1)+"位评委的分数");
            int score = sc.nextInt();
            if(score>0&&score<=100){
                arr[i] = score;
                i++;
            }else{
                System.out.println("不合法，请重新输入第"+(i+1)+"位评委的分数");
            }
        }
        int max= getMax(arr);
        int min = getMin(arr);
        int sum = getSum(arr);
        int avg = (sum-max-min)/arr.length;
        System.out.println(avg);


    }
    public static int getMin(int arr[]){
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(min>arr[i]){
                min= arr[i];
            }
        }return min;
    }
    public static int getMax(int arr[]){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max= arr[i];
            }
        }return max;
    }
    public static int getSum(int [] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
