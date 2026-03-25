import java.util.Scanner;

public class chaifenshuzi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int a = num1 / 100;
        int b = num1 /10%10;
        int c = num1 %10;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
