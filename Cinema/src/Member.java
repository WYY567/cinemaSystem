import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.security.SecureRandom;
import java.util.Random;

public class Member extends JFrame implements ActionListener {
    JMenu menu;
    JMenuItem menuItem;
    JMenuItem menuItem1;
    JMenu menuItem2;
    JMenuItem menuItem3;
    JMenuItem menuItem4;

    public Member() {
        setLayout(new FlowLayout());
        setVisible(true);
        setTitle("用户");
        setBounds(60, 100, 500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        menu = new JMenu("菜单");
        menuItem = new JMenuItem("注册");
        menuItem1 = new JMenuItem("登录");
        menuItem2 = new JMenu("密码管理");
        menuItem3 = new JMenuItem("修改自身密码");
        menuItem4 = new JMenuItem("忘记密码");
        menuItem2.add(menuItem3);
        menuItem2.add(menuItem4);
        menu.add(menuItem);
        menu.add(menuItem1);
        menu.add(menuItem2);
        menubar.add(menu);
        menuItem.addActionListener(this);
        menuItem1.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem) {
            new win1();
            this.setVisible(false);
        }
        if (e.getSource() == menuItem1) {
            new win2();
            this.setVisible(false);
        }
        if (e.getSource() == menuItem3) {
            new win4();
            this.setVisible(false);
        }
        if (e.getSource() == menuItem4) {
            new win4();
        }
    }
}

class win1 extends JFrame implements ActionListener {
    JLabel label1;
    JTextField field1;
    JLabel label2;
    JTextField field2;

    public win1() {
        setLayout(new FlowLayout());
        setBounds(0, 0, 500, 300);
        setVisible(true);
        setTitle("注册");
        label1 = new JLabel("用户名长度不少于5个字符");
        field1 = new JTextField(10);
        label2 = new JLabel("密码长度大于8个字符，必须是大小写字母、数字和标点符号的组合。");
        field2 = new JTextField(10);
        JButton button = new JButton("确定");
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(button);
        button.addActionListener(this);
        field1.addActionListener(this);
        field2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String str1 = field1.getText();
        String str2 = field2.getText();
        int a = 0;
        if (str1.length() < 5) {
            JOptionPane.showMessageDialog(null, "用户名长度不少于5个字符", "警告", JOptionPane.WARNING_MESSAGE);
        }
        if (str2.length() < 8) {
            JOptionPane.showMessageDialog(null, "密码长度不得小于八", "警告", JOptionPane.WARNING_MESSAGE);
        } else if (str2.length() > 8) {
            if (str2.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=~`{}\\[\\]|:;\"'<>,.?/]).+$")) {
                JOptionPane.showMessageDialog(null, "注册成功", "", JOptionPane.WARNING_MESSAGE);
                str1 = str1 + ".txt";
                File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",str1);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                        FileWriter tofile = new FileWriter(file);
                        BufferedWriter out = new BufferedWriter(tofile);
                        out.write(str2);
                        out.close();
                    } catch (IOException exp) {
                        System.out.println("创建失败");
                    }
                } else {
                    try {
                        FileWriter tofile = new FileWriter(file);
                        BufferedWriter out = new BufferedWriter(tofile);
                        out.write(str2);
                        out.close();
                    } catch (IOException exp) {
                        System.out.println("密码输入失败");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "您的密码不是大小写字母、数字和标点符号的组合", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}


class win2 extends JFrame implements ActionListener {
    JButton botton = new JButton("确定");
    JLabel label1 = new JLabel("账号");
    JLabel label2 = new JLabel("密码");
    JTextField field1 = new JTextField(15);
    JPasswordField field2 = new JPasswordField(15);

    public win2() {
        setLayout(new FlowLayout());
        setTitle("登录");
        setVisible(true);
        setBounds(0, 0, 500, 300);
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(botton);
        botton.addActionListener(this);
        field1.addActionListener(this);
        field2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = field1.getText();
        str1 = str1 + ".txt";
        char[] str2 = field2.getPassword();
        String str3 = String.valueOf(str2);
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",str1);
        if (file.exists()) {
            try {
                FileReader inOne = new FileReader(file);
                BufferedReader inTwo = new BufferedReader(inOne);
                String password = null;
                password = inTwo.readLine();
                if (str3.equals(password)) {
                    new win3();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "密码错误", "警告", JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException exp) {
                System.out.println(exp);
            }
        } else {
            JOptionPane.showMessageDialog(null, "该用户不存在，请您先注册再登陆", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class win3 extends JFrame{
    JTabbedPane p;
    win7 w7;
    win8 w8;
    Foot_the_bill bill;
    Pick_up_ticket pick;
    Buy_ticket buy;
    win3() {
        p = new JTabbedPane();
        w7 = new win7();
        p.add("查看所有电影放映信息",w7);
        w8 = new win8();
        p.add("查看指定电影",w8);
        add(p);
        buy = new Buy_ticket();
        p.add("订票及选座",buy);
        bill = new Foot_the_bill();
        p.add("付账",bill);
        pick = new Pick_up_ticket();
        p.add("取票",pick);
        setTitle("用户购票界面");
        setVisible(true);
        setBounds(0, 0, 800, 700);
    }
}

//查看所有电影放映信息的类
class win7 extends JPanel implements ActionListener{
    JTextArea area;
    JButton button;
    win7(){
        setLayout(new FlowLayout());
        button = new JButton("列出所有影片信息");
        area = new JTextArea(10,10);
        add(button);
        add(area);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        File file = new File("电影信息");
        String []str = file.list();
        String information;
        for(String str1:str){
            File file1 = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电影信息",str1);
            try{
                FileReader inOne = new FileReader(file1);
                BufferedReader inTwo = new BufferedReader(inOne);
                while((information = inTwo.readLine())!=null){
                    area.append(information);
                    area.append("\n");
                }
                area.append("\n\n");
            }
            catch(IOException exp){
                System.out.println(exp);
            }

        }
    }
}

//查看指定电影放映信息的类
class win8 extends JPanel implements ActionListener {
    JLabel label;
    JButton button;
    JTextField field;
    JTextArea area;

    win8() {
        setLayout(new FlowLayout());
        label = new JLabel("输入电影名进行查询");
        button = new JButton("确认");
        field = new JTextField(15);
        area = new JTextArea(9, 30);
        add(label);
        add(field);
        add(button);
        add(area);
        field.addActionListener(this);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = field.getText();
        String information;
        try {
            id = id + ".txt";
            File file1 = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电影信息", id);
            FileReader inOne = new FileReader(file1);
            BufferedReader inTwo = new BufferedReader(inOne);
            while((information = inTwo.readLine())!=null) {
                area.append(information);
                area.append("\n");
            }
            area.append("\n\n");
        } catch (IOException exp) {
            System.out.println(exp);
        }
    }
}
//购票以及买票的类


class win4 extends JFrame{
    win5 w5;
    win6 w6;
    JTabbedPane p;

    win4() {
        w5 = new win5();
        w6 = new win6();
        p = new JTabbedPane();
        p.add("修改自身密码", w5);
        p.add("忘记密码", w6);
        add(p);
        setVisible(true);
        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class win5 extends JPanel implements ActionListener {
    JLabel label1;
    JTextField field1;
    JLabel label2;
    JTextField field2;
    JButton button;

    win5() {
        setLayout(new FlowLayout());
        label1 = new JLabel("输入账号来修改密码");
        field1 = new JTextField(15);
        label2 = new JLabel("输入您想改成的密码");
        field2 = new JTextField(15);
        button = new JButton("确定");
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(button);
        field1.addActionListener(this);
        field2.addActionListener(this);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = field1.getText();
        str1 = str1 + ".txt";
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",str1);
        if (file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.close(); // 关闭文件写入流会清空文件内容
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String str2 = field2.getText();
            if (str2.length() < 8) {
                JOptionPane.showMessageDialog(null, "密码长度不得小于八", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else if (str2.length() > 8) {
                if (str2.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=~`{}\\[\\]|:;\"'<>,.?/]).+$")) {
                    try {
                        FileWriter tofile = new FileWriter(file);
                        BufferedWriter out = new BufferedWriter(tofile);
                        out.write(str2);
                        out.close();
                        JOptionPane.showMessageDialog(null, "密码修改成功", "", JOptionPane.WARNING_MESSAGE);
                    } catch (IOException exp) {
                        System.out.println("密码输入失败");
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "该账号不存在，请您检查账号是否错误或先去注册账号", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class win6 extends JPanel implements ActionListener {
    JTextField field1;
    JTextField field2;
    JButton button;
    JLabel label1;
    JLabel label2;

    win6() {
        setLayout(new FlowLayout());
        label1 = new JLabel("输入用户名");
        field1 = new JTextField(15);
        label2 = new JLabel("输入邮箱");
        field2 = new JTextField(15);
        button = new JButton("确定");
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(button);
        field1.addActionListener(this);
        field2.addActionListener(this);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1 = field1.getText();
        str1 = str1 + ".txt";
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",str1);
        String str2 = field2.getText();
        if (file.exists()) {
            try {
                FileWriter writer = new FileWriter(file);
                writer.close(); // 关闭文件写入流会清空文件内容
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Generate_a_random_password new_password = new Generate_a_random_password();
            String str3 = new_password.generateRandomString(8);
            try {
                FileWriter tofile = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(tofile);
                out.write(str3);
                out.close();
                JOptionPane.showMessageDialog(null, "您可以登陆到邮箱查看您的密码", "警告", JOptionPane.WARNING_MESSAGE);
            } catch (IOException exp) {
                System.out.println(exp);
            }
        } else {
            JOptionPane.showMessageDialog(null, "该账号不存在，请您检查账号是否错误或先去注册账号", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class Generate_a_random_password {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";

    public String generateRandomString(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder s = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            s.append(randomChar);
        }
        return s.toString();
    }
}

class Buy_ticket extends JPanel implements ActionListener{
    JLabel label;
    JButton button1;
    JTextField field;
    String name;
    File file_one,file_two,file_three,file_four,file_five;
    String []one;
    String []two;
    String []three;
    String []four;
    String []five;
    String position1,position2,position3,positon4,positon5;
    Buy_ticket(){
        setLayout(new FlowLayout());
        label = new JLabel("输入电影名进行订票及选座");
        field = new JTextField(10);
        button1 = new JButton("确定");
        add(label);
        add(field);
        add(button1);
        field.addActionListener(this);
        button1.addActionListener(this);
        position1 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\一号放映厅";
        file_one = new File(position1);
        position2 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\二号放映厅";
        file_two = new File(position2);
        position3 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\三号放映厅";
        file_three = new File(position3);
        positon4 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\四号放映厅";
        file_four = new File(positon4);
        positon5 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\五号放映厅";
        file_five = new File(positon5);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        name = field.getText();
        name = name+".txt";
        one = file_one.list();
        two = file_two.list();
        three = file_three.list();
        four = file_four.list();
        five = file_five.list();
        if(one[1].equals(name)){
            new select_position(position1);
        }
        else if(two[1].equals(name)){
            new select_position(position2);
        }
        else if(three[1].equals(name)){
            new select_position(position3);
        }
        else if(four[1].equals(name)){
            new select_position(positon4);
        }
        else if(five[1].equals(name)){
            new select_position(positon5);
        }
        else {
            JOptionPane.showMessageDialog(null, "该电影还未上映，敬请期待", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class select_position extends JFrame implements ActionListener{
    JTextField line,column;
    JLabel label1,label2;
    JTextArea area;
    JButton button;
    String hang,lie,information;
    File file;
    char pos[];
    FileReader inOne;
    BufferedReader inTwo;
    String fileContent = "";

    select_position(String position){
        position = position + "\\位置信息.txt";
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0,0,700,500);
        line = new JTextField(3);
        column = new JTextField(3);
        JLabel label3 = new JLabel("x:已被选择");
        button = new JButton("确定");
        label1 = new JLabel("行");
        label2 = new JLabel("列");
        area = new JTextArea(15,20);
        add(label1);
        add(line);
        add(label2);
        add(column);
        add(button);
        add(area);
        line.addActionListener(this);
        column.addActionListener(this);
        button.addActionListener(this);
        file = new File(position);
        try{
            inOne = new FileReader(file);
            inTwo = new BufferedReader(inOne);
            while((information = inTwo.readLine())!=null){
                area.append(information);
                area.append("\n");
            }
        }catch(IOException exp){
            JOptionPane.showMessageDialog(null, exp, "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        hang = line.getText();
        lie = column.getText();
        int number1 = Integer.parseInt(hang);
        int number2 = Integer.parseInt(lie);
        if(number1>7||number2>12){
            JOptionPane.showMessageDialog(null, "位置选择错误，请查看您输入的行和列是否正确", "警告", JOptionPane.WARNING_MESSAGE);
        }
        else{
            try{
                inOne = new FileReader(file);
                inTwo = new BufferedReader(inOne);
                while((information = inTwo.readLine())!=null){
                    pos = information.toCharArray();
                    int number = Character.getNumericValue(pos[0]);
                    if(number == number1){
                        if(pos[number2*6-1]=='x'){
                            JOptionPane.showMessageDialog(null, "该座位已被选择", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                            pos[number2*6-1] = 'x';
                            JOptionPane.showMessageDialog(null, "选座成功，关闭该页面进行刷新",null, JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    information = new String(pos);
                    fileContent += information + System.lineSeparator();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(fileContent);
                }
                fileContent = "";
            }catch(IOException exp){
                JOptionPane.showMessageDialog(null, exp, "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}

class Foot_the_bill extends JPanel implements ActionListener{
    JTextField field;
    JButton button;
    Foot_the_bill(){
        button = new JButton("付款");
        add(button);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int ID = generateRandomNumber();
        String str = String.valueOf(ID);
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电子ID编号",str+".txt");
        File file1 = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\购票历史\\购票历史");
        if(!file.exists()){
            try {
                file.createNewFile();
                JOptionPane.showMessageDialog(null, "付款成功，您的电子ID编号是："+str, "警告", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    public  int generateRandomNumber() {
        int max = 999999;
        int min = 100000;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}

class Pick_up_ticket extends JPanel implements ActionListener{
    JLabel label;
    JTextField field;
    JButton button;
    String id;
    String path;

     Pick_up_ticket(){
        label = new JLabel("输入电子ID编号进行取票");
        field = new JTextField(10);
        button = new JButton("确定");
        add(label);
        add(field);
        add(button);
        field.addActionListener(this);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         id = field.getText();
         File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电子ID编号",id+".txt");
         if(file.exists()){
             JOptionPane.showMessageDialog(null, "取票成功", "警告", JOptionPane.WARNING_MESSAGE);
             file.delete();
         }
         else{
             JOptionPane.showMessageDialog(null, "取票失败，票已经被取出，不能重复取票", "警告", JOptionPane.WARNING_MESSAGE);
         }
    }

}
