package Basic.practice;

import java.util.Scanner;

public class if_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票价格");
        double price = sc.nextInt();
        System.out.println("请输入购买的月份");
        int month = sc.nextInt();
        System.out.println("请输入经济舱（0）还是头等舱（1）");
        int kind = sc.nextInt();
        if(month>5&&month<10){
            if(kind == 0){
                price = 0.85*price;
            }else if(kind ==1){
                price = 0.9*price;
            }else{
                System.out.println("请输入正确的舱位");
            }
        }else if(month<=4&&month>=11){if(kind == 0){
            price = 0.65*price;
        }else if(kind ==1){
            price = 0.7*price;
        }else{
            System.out.println("请输入正确的舱位");
        }

        }else{
            System.out.println("数据不合法");
        }
        System.out.println(price);
    }
}
