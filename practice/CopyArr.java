package Basic.practice;

public class CopyArr {
    public static void main(String[] args) {
        int []arr = {1,2,3,4};
        int []arr1 = new int[arr.length];
        for (int i = 0,j=0; i < arr.length; j++,i++) {
            arr1[j]=arr[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            if(i!=arr.length-1){
                System.out.print(arr1[i]+" ");
            }else{
                System.out.print(arr1[i]);
            }
        }
    }
}
