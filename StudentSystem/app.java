package StudentSystem;

import javax.print.attribute.standard.JobOriginatingUserName;
import javax.xml.transform.Source;
import java.lang.invoke.StringConcatFactory;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<user> list = new ArrayList<>();
        while (true) {
            System.out.println("---欢迎来到学生管理系统---");
            System.out.println("请选择操作：1登录，2注册，3忘记密码，4退出");
            String choose = sc.next();
            switch (choose){
                case "2"-> register(list);
                case"1"-> login(list);
                case "3"-> forget(list);
                case"4"->{
                    System.out.println("谢谢使用");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    private static void forget(ArrayList<user> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        boolean flag = contains(list,username);
        if(!flag){
            System.out.println("用户名不存在");
            return;
        }
        System.out.println("请输入身份证");
        String personID= sc.next();
        System.out.println("请输入电话号码");
        String phoneNumber = sc.next();
        int index = getIndex(list,username);
        user use = list.get(index);
        if(!(use.getPhonenumber().equals(phoneNumber)&&use.getPersonID().equalsIgnoreCase(personID))){
            System.out.println("身份证或电话号码错误");
            return;
        }String pa1;
        while (true) {
            System.out.println("请输入新的密码");
             pa1 = sc.next();
            System.out.println("请再次输入密码");
            String pa2 = sc.next();
            if(!(pa1.equals(pa2))){
                System.out.println("两次密码不一致，请重新输入");
                continue;
            }else{
                break;
            }
        }list.get(index).setPassword(pa1);
        System.out.println(list.get(index).getPassword());
        System.out.println("密码修改成功，请重新登录");
    }

    private static void login(ArrayList<user> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i<4;i++) {
            System.out.println("请输入用户名");
            String username = sc.next();
            boolean flag = contains(list,username);
            if(!flag){
                System.out.println("用户名不存在，请先注册");
                return;
            }
            while (true) {
                String code = getCode();
                System.out.println(code);
                System.out.println("请输入验证码");
                String code1 = sc.next();
                if(!(code1.equals(code))){
                    System.out.println("验证码错误，请重新输入");
                    continue;
                }else{
                    break;
                }
            }//密码
            System.out.println("请输入密码");
            String password = sc.next();
            user use = new user(username,null,null,password);
            boolean flag1 = checkInfo(use,list);
            if(flag1){
                System.out.println("登陆成功");
                StudentTest ss = new StudentTest();
                ss.studentSystem();
                break;
            }else{
                System.out.println("用户名或密码错误");
                System.out.println("当前还有"+(2-i)+"次机会");
            }if(i==2){
                System.out.println("当前账户已被锁定");
                return;
            }
        }
    }

    private static boolean checkInfo(user use,ArrayList<user> list) {
        for (int i = 0; i < list.size(); i++) {
            user use1 = list.get(i);
            if((use.getUsername().equals(use1.getUsername()))&&use.getPassword().equals(use1.getPassword())){
                return true;
            }
        }return false;
    }

    private static String getCode() {
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

    private static void register(ArrayList<user> list) {
        Scanner sc = new Scanner(System.in);
        //用户名
        String username;
        while (true) {
            System.out.println("请输入用户名");
            username = sc.next();
            //判断用户名格式
            boolean flag = checkUsername(username);
            if(!flag){
                System.out.println("格式错误，请重新输入");
                continue;
            }else{
                if(contains(list,username)){
                    System.out.println("用户名存在，请重新输入");
                    continue;
                }else{break;}
            }
        }//密码
        String password1;
        while (true) {
            System.out.println("请输入密码");
            password1 = sc.next();
            System.out.println("请再次输入密码");
            String password2 = sc.next();
            if(!password1.equals(password2)){
                System.out.println("两次密码不一致，请重新设置");
                continue;
            }else{
                break;
            }
        }//身份证号码
        String personID;
        while (true) {
            System.out.println("请输入身份证号码");
            personID = sc.next();
            boolean flag = checkPersonID(personID);
            if(!flag){
                System.out.println("格式错误，请重新输入");
                continue;
            }else{
                break;
            }
        }//手机号码
        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号");
            phoneNumber = sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if(!flag){
                System.out.println("请重新输入");
                continue;
            }else{
                break;
            }
        }
        user us = new user(username,personID,phoneNumber,password1);
        list.add(us);
        System.out.println(list);
        searchList(list);
    }

    private static void searchList(ArrayList<user> list) {
        for (int i = 0; i < list.size(); i++) {
            user us = list.get(i);
            System.out.println(us.getUsername()+us.getPersonID()+us.getPassword()+us.getPhonenumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=11){
            return false;
        }if(phoneNumber.startsWith("0")){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }return true;
    }

    private static boolean checkPersonID(String personID) {
        if(personID.length()!=18){
            return false;
        }if(personID.startsWith("0")){
            return false;
        }
        for (int i = 0; i < personID.length()-1; i++) {
            char c = personID.charAt(i);
            if(!(c>='0'&&c<='9')){
                return false;
            }
        }char c = personID.charAt(personID.length()-1);
        if(!((c>='0'&&c<='9')||c=='x'||c=='X')){
            return false;
        }return true;
    }

    private static boolean checkUsername(String username) {
        if(username.length()<3||username.length()>15){
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))){
                return false;
            }
        }int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                count++;
                break;
            }
        }return count>0;
    }

    private static int getIndex(ArrayList<user> list,String username){
        for (int i = 0; i < list.size(); i++) {
            user us = list.get(i);
            String name = us.getUsername();
            if(name.equals(username)){
                return i;
            }
        }return -1;
    }
    public static boolean contains(ArrayList<user> list,String username){
        if(getIndex(list,username)==-1){
            return false;
        }return true;
    }
}
