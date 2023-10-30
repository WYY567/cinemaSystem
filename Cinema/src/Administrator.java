import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.*;

public class Administrator extends JFrame {
    log_in log;
    JTabbedPane p;
    public Administrator(){
        p = new JTabbedPane();
        log = new log_in();
        p.add("登录",log);
        add(p);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(10,10,570,570);
        setVisible(true);
        setTitle("管理员");
    }
}

class log_in extends JPanel implements ActionListener {
    JButton botton = new JButton("确定");
    JLabel label1 = new JLabel("账号");
    JLabel label2 = new JLabel("密码");
    JTextField field1 = new JTextField(15);
    JPasswordField field2 = new JPasswordField(15);

    public log_in() {
        setLayout(new FlowLayout());
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
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\管理员信息",str1);
        if (file.exists()) {
            try {
                FileReader inOne = new FileReader(file);
                BufferedReader inTwo = new BufferedReader(inOne);
                String password = null;
                password = inTwo.readLine();
                if (str3.equals(password)) {
                    new Administrator_interface();
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


class Administrator_interface extends JFrame{
    JTabbedPane p;
    Password_management pm;
    User_management user_management;
    Administrator_interface(){
        p = new JTabbedPane();
        pm = new Password_management();
        user_management = new User_management();
        p.add("密码管理",pm);
        p.add("用户管理",user_management);
        add(p);
        setVisible(true);
        setBounds(0,0,650,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

class Password_management extends JPanel{
    Change_my_password change_me;
    Change_User_password change_user;
    JTabbedPane p;
    Password_management(){
        p = new JTabbedPane();
        change_me = new Change_my_password();
        change_user = new Change_User_password();
        p.add("修改自身密码",change_me);
        p.add("重置指定用户密码",change_user);
        add(p);
    }
}
class Change_my_password extends JPanel implements ActionListener {
    JLabel label1;
    JTextField field1;
    JLabel label2;
    JTextField field2;
    JButton button;

    Change_my_password() {
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
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\管理员信息",str1);
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
                else{
                    JOptionPane.showMessageDialog(null, "您的密码不是大小写字母、数字和标点符号的组合", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "该账号不存在，请您检查账号是否错误或先去注册账号", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class Change_User_password extends JPanel implements ActionListener {
    JLabel label1;
    JTextField field1;
    JLabel label2;
    JTextField field2;
    JButton button;

    Change_User_password() {
        setLayout(new FlowLayout());
        label1 = new JLabel("输入用户账号来修改密码");
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
                else{
                    JOptionPane.showMessageDialog(null, "您的密码不是大小写字母、数字和标点符号的组合", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "该账号不存在，请您检查账号是否错误或先去注册账号", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class User_management extends JPanel{
    JTabbedPane p;
    List_all_users user;
    Querying_User_Information find;
    Deleting_User_Information delete_user;
    User_management(){
        p = new JTabbedPane();
        user = new List_all_users();
        delete_user = new Deleting_User_Information();
        find = new Querying_User_Information();
        p.add("显示所有用户信息",user);
        p.add("删除用户信息",delete_user);
        p.add("查找用户信息",find);
        add(p);
    }
}

class List_all_users extends JPanel implements ActionListener{
    File file;
    JTextArea area;
    JButton button;
    String []all_user;
    List_all_users(){
        file = new File("用户信息");
        all_user = file.list();
        area = new JTextArea(9,30);
        button = new JButton("列出所有用户的信息");
        add(button);
        add(area);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String information;
        for(String str : all_user){
            try{
                area.append("id为"+str+"的用户:");
                area.append("\n");
                File file1 = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",str);
                FileReader inOne = new FileReader(file1);
                BufferedReader inTwo = new BufferedReader(inOne);
                int a = 1;
                while((information = inTwo.readLine())!=null){
                    if(a == 1){
                        a++;
                        continue;
                    }
                    area.append(information);
                    area.append("\n");
                }
                inTwo.close();
            }
            catch(IOException exp){
                System.out.println(exp);
            }
        }
    }
}

class Deleting_User_Information extends JPanel implements ActionListener {
    JLabel label;
    JTextField field;
    JButton button;
    File file;
    String id;
    Deleting_User_Information(){
        label = new JLabel("请输入您要删除的用户的账号");
        field = new JTextField(15);
        button = new JButton("确认");
        add(label);
        add(field);
        add(button);
        field.addActionListener(this);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        id = field.getText();
        id = id + ".txt";
        file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",id);
        int n = JOptionPane.showConfirmDialog(null,"您确定要删除这个用户的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
        if(n == JOptionPane.YES_OPTION){
            file.delete();
            JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "未删除", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class Querying_User_Information extends JPanel implements ActionListener{
    JLabel label;
    JButton button;
    JTextField field;
    JTextArea area;
    Querying_User_Information(){
        label = new JLabel("输入用户id查询");
        button = new JButton("确认");
        field = new JTextField(15);
        area = new JTextArea(9,30);
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
        try{
            area.append("id为"+id+"的用户:");
            area.append("\n");
            id = id + ".txt";
            File file1 = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\用户信息",id);
            FileReader inOne = new FileReader(file1);
            BufferedReader inTwo = new BufferedReader(inOne);
            int a = 1;
            while((information = inTwo.readLine())!=null){
                if(a == 1){
                    a++;
                    continue;
                }
                area.append(information);
                area.append("\n");
            }
            inTwo.close();
        }
        catch(IOException exp){
            System.out.println(exp);
        }
    }
}

