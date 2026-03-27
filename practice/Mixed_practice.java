package Basic.practice;


public class Mixed_practice {
    public static void main(String[] args) {
        int num = 1000;
        int temp = num;
        int count = 0;
        while(num!=0){
            count++;
            num/=10;
        }int[]arr = new int[count];
        for (int i = arr.length-1; i >=0; i--) {
            arr[i]=temp%10;
            temp = temp/10;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]+=5;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]%=10;
        }
        for (int i = 0,j=arr.length-1; i < j; i++,j--) {
            int temp1 = arr[i];
            arr[i]=arr[j];
            arr[j]=temp1;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result=result*10+arr[i];
        }
        System.out.println(result);
    }

}
