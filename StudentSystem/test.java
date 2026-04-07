package StudentSystem;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        System.out.println(getCode());

    }    private static String getCode() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list =new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            sb.append(list.get(index));
        }int index = r.nextInt(10);
        sb.append(index);
        char[]arr=sb.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index1 = r.nextInt(arr.length);
           char temp= arr[index1];
           arr[index1]=arr[arr.length-1];
           arr[arr.length-1]=temp;
        }
        return new String(arr);
    }
}
