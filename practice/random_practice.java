package Basic.practice;

import java.util.Random;

public class random_practice {
    public static void main(String[] args) {
        char[]arr = new char[52];
        for (int i = 0; i < arr.length; i++) {
            if(i<=25){
                arr[i]=(char)(97+i);
            }else{
                arr[i]=(char)(65+i-26);
            }
        }Random r = new Random();
        String result="";
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(arr.length);
            result+=arr[index];
        }int r1 = r.nextInt(10);
        result+=r1;
        System.out.println(result);
    }
}
