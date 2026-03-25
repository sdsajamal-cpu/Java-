import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 面向初学者的学生管理系统（控制台版本）
 * 功能：新增、查看全部、按学号查询、修改、删除、统计人数、退出
 */
public class StudentManagementSystem {

    /**
     * 学生实体类：用于保存一个学生的数据
     */
    static class Student {
        private String id;
        private String name;
        private int age;
        private double score;

        public Student(String id, String name, int age, double score) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return String.format("学号: %s, 姓名: %s, 年龄: %d, 成绩: %.1f", id, name, age, score);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            printMenu();
            System.out.print("请输入操作编号: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner, students);
                    break;
                case "2":
                    listStudents(students);
                    break;
                case "3":
                    findStudentById(scanner, students);
                    break;
                case "4":
                    updateStudent(scanner, students);
                    break;
                case "5":
                    deleteStudent(scanner, students);
                    break;
                case "6":
                    countStudents(students);
                    break;
                case "0":
                    System.out.println("系统已退出，欢迎下次使用！");
                    scanner.close();
                    return;
                default:
                    System.out.println("输入无效，请输入菜单中的编号。\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("================ 学生管理系统 ================");
        System.out.println("1. 新增学生");
        System.out.println("2. 查看全部学生");
        System.out.println("3. 按学号查询学生");
        System.out.println("4. 修改学生信息");
        System.out.println("5. 删除学生");
        System.out.println("6. 统计学生人数");
        System.out.println("0. 退出系统");
        System.out.println("============================================");
    }

    private static void addStudent(Scanner scanner, List<Student> students) {
        System.out.print("请输入学号: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("学号不能为空！\n");
            return;
        }

        if (getStudentById(id, students) != null) {
            System.out.println("该学号已存在，不能重复添加。\n");
            return;
        }

        System.out.print("请输入姓名: ");
        String name = scanner.nextLine().trim();

        int age;
        try {
            System.out.print("请输入年龄: ");
            age = Integer.parseInt(scanner.nextLine().trim());
            if (age <= 0) {
                System.out.println("年龄必须大于 0。\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("年龄格式错误，请输入整数。\n");
            return;
        }

        double score;
        try {
            System.out.print("请输入成绩: ");
            score = Double.parseDouble(scanner.nextLine().trim());
            if (score < 0 || score > 100) {
                System.out.println("成绩范围应在 0 到 100 之间。\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("成绩格式错误，请输入数字。\n");
            return;
        }

        students.add(new Student(id, name, age, score));
        System.out.println("添加成功！\n");
    }

    private static void listStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("当前暂无学生数据。\n");
            return;
        }

        System.out.println("----- 学生列表 -----");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.println();
    }

    private static void findStudentById(Scanner scanner, List<Student> students) {
        System.out.print("请输入要查询的学号: ");
        String id = scanner.nextLine().trim();

        Student student = getStudentById(id, students);
        if (student == null) {
            System.out.println("未找到该学号对应的学生。\n");
        } else {
            System.out.println("查询结果: " + student + "\n");
        }
    }

    private static void updateStudent(Scanner scanner, List<Student> students) {
        System.out.print("请输入要修改的学号: ");
        String id = scanner.nextLine().trim();
        Student student = getStudentById(id, students);

        if (student == null) {
            System.out.println("未找到该学号对应的学生。\n");
            return;
        }

        System.out.print("请输入新姓名（直接回车表示不修改）: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            student.setName(newName);
        }

        System.out.print("请输入新年龄（直接回车表示不修改）: ");
        String ageInput = scanner.nextLine().trim();
        if (!ageInput.isEmpty()) {
            try {
                int newAge = Integer.parseInt(ageInput);
                if (newAge <= 0) {
                    System.out.println("年龄必须大于 0，已取消本次修改。\n");
                    return;
                }
                student.setAge(newAge);
            } catch (NumberFormatException e) {
                System.out.println("年龄格式错误，已取消本次修改。\n");
                return;
            }
        }

        System.out.print("请输入新成绩（直接回车表示不修改）: ");
        String scoreInput = scanner.nextLine().trim();
        if (!scoreInput.isEmpty()) {
            try {
                double newScore = Double.parseDouble(scoreInput);
                if (newScore < 0 || newScore > 100) {
                    System.out.println("成绩范围应在 0 到 100 之间，已取消本次修改。\n");
                    return;
                }
                student.setScore(newScore);
            } catch (NumberFormatException e) {
                System.out.println("成绩格式错误，已取消本次修改。\n");
                return;
            }
        }

        System.out.println("修改成功！\n");
    }

    private static void deleteStudent(Scanner scanner, List<Student> students) {
        System.out.print("请输入要删除的学号: ");
        String id = scanner.nextLine().trim();
        Student student = getStudentById(id, students);

        if (student == null) {
            System.out.println("未找到该学号对应的学生。\n");
            return;
        }

        students.remove(student);
        System.out.println("删除成功！\n");
    }

    private static void countStudents(List<Student> students) {
        System.out.println("当前学生总人数: " + students.size() + "\n");
    }

    private static Student getStudentById(String id, List<Student> students) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
