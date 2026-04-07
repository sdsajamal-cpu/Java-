package StudentSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void studentSystem() {
        ArrayList<student> list = new ArrayList<>();
        loop:while (true) {
            System.out.println("--------欢迎来到学生管理系统-------");
            System.out.println("1:添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose){
                case "1"-> add(list);
                case "2"-> delete(list);
                case "3"-> update(list);
                case "4"-> search(list);
                case "5"-> {System.out.println("退出");
                            break loop;
                            //System.exit(0);
                            }
                default -> System.out.println("没有这个选项");
            }
        }
    }
    public static void add(ArrayList<student> list){
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入id");
            id = sc.next();
            if(getIndex(list,id)>=0){
                System.out.println("id已存在，请重新输入");
            }else{
                break;
            }}
            System.out.println("请输入姓名");
            String name = sc.next();
            System.out.println("请输入地址");
            String address = sc.next();
            System.out.println("请输入年龄");
            int age = sc.nextInt();
            student stu = new student(name,age,id,address);
            list.add(stu);

    }
    public static void delete(ArrayList<student> list){
        //判断id是否存在
        String id ;
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入id");
            id = sc.next();
            if(getIndex(list,id)==-1){
                System.out.println("输入的id不存在，重新输入");
            }else{
                break;
            }
        }int index = getIndex(list,id);
        list.remove(index);
        System.out.println("删除成功");
    }
    public  static void update(ArrayList<student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要更新的id");
        String id = sc.next();
        if(getIndex(list,id)==-1){
            System.out.println("id不存在，已退出");
            return;
        }else{
            int index = getIndex(list,id);
            System.out.println("请输入新的姓名");
            String name = sc.next();
            list.get(index).setName(name);
            System.out.println("请输入新的地址");
            String adress = sc.next();
            list.get(index).setAddress(adress);
            System.out.println("请输入新的年龄");
            int age = sc.nextInt();
            list.get(index).setAge(age);
        }
        System.out.println("修改成功");
        return;
    }
    public static void search(ArrayList<student> list){
        if(list.size()==0){
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }else{
            System.out.println("id\t\t\t姓名\t年龄\t家庭住址\t");
            for (int i = 0; i < list.size(); i++) {
                student stu = list.get(i);
                System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge() +"\t"+stu.getAddress()+"\t");

            }
        }

    }

    //判断Id是否重复
    public static int getIndex(ArrayList<student>list,String id){
        for (int i = 0; i < list.size(); i++) {
            student stu = list.get(i);
            if(stu.getId().equals(id)){
                return i;
            }
        }return -1;
    }
}
