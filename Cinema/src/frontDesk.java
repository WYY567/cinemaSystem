import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class frontDesk extends JFrame implements ActionListener {
    JLabel label1;
    JLabel lable2;
    JTextField field1;
    JPasswordField field2;
    JButton button;
    String Account_number;
    String password;
    public frontDesk(){
        setLayout(new FlowLayout());
        label1 = new JLabel("账号");
        lable2 = new JLabel("密码");
        field1 = new JTextField(15);
        field2 = new JPasswordField(15);
        button = new JButton("确定");
        add(label1);
        add(field1);
        add(lable2);
        add(field2);
        add(button);
        field1.addActionListener(this);
        field2.addActionListener(this);
        button.addActionListener(this);
        setTitle("前台登录");
        setVisible(true);
        setBounds(60,100,500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Account_number = field1.getText();
        password = field2.getText();
        Account_number = Account_number+".txt";
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\前台信息",Account_number);
        try{
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String str = inTwo.readLine();
            if(str.equals(password)){
                new front_desk_functin();
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "密码错误", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(IOException exp){
            System.out.println(exp);
        }
    }
}

class front_desk_functin extends JFrame{
    JTabbedPane p;
    List_movie list;
    List_session_information l;
    Ticket_sale sale;
    front_desk_functin(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setBounds(60,100,800,700);
        setTitle("前台功能");
        p = new JTabbedPane();
        list = new List_movie();
        p.add("列出所有影片信息",list);
        l = new List_session_information();
        p.add("列出指定电影场次的信息",l);
        sale = new Ticket_sale();
        p.add("售票功能",sale);
        add(p);
    }
}

class List_movie extends JPanel implements ActionListener{
    JTextArea area;
    JButton button;
    List_movie(){
        setLayout(new FlowLayout());
        button = new JButton("列出所有影片信息");
        area = new JTextArea(10,10);
        add(button);
        add(area);
        button.addActionListener(this);
        setVisible(true);
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


class List_session_information extends JPanel implements ActionListener{
    JButton button = new JButton("确定");
    JTextField field = new JTextField(10);

    JTextArea area = new JTextArea(20,20);
    String str1 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\一号放映厅";
    File file1 = new File(str1);
    String str2 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\二号放映厅";
    File file2 = new File(str2);
    String str3 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\三号放映厅";
    File file3 = new File(str3);
    String str4 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\四号放映厅";
    File file4 = new File(str4);
    String str5 = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\五号放映厅";
    File file5 = new File(str5);
    String list1[];
    List_session_information(){
        add(field);
        add(button);
        add(area);
        field.addActionListener(this);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = field.getText();
        name = name+".txt";
        list1 = file1.list();
        if(list1[1].equals(name)){
            for(int i = 0; i<2;i++){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\一号放映厅"+"\\"+list1[i];
                String information;
                File f = new File(string);
                try{
                    FileReader inOne = new FileReader(f);
                    BufferedReader inTwo = new BufferedReader(inOne);
                    while((information = inTwo.readLine())!=null) {
                        area.append(information);
                        area.append("\n");
                    }
                }  catch(IOException exp){}
            }
        }
        list1 = file2.list();
        if(list1[1].equals(name)){
            for(int i = 0; i<2;i++){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\二号放映厅"+"\\"+list1[i];
                String information;
                File f = new File(string);
                try{
                    FileReader inOne = new FileReader(f);
                    BufferedReader inTwo = new BufferedReader(inOne);
                    while((information = inTwo.readLine())!=null) {
                        area.append(information);
                        area.append("\n");
                    }
                }  catch(IOException exp){}
            }
        }
        list1 = file3.list();
        if(list1[1].equals(name)){
            for(int i = 0; i<2;i++){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\三号放映厅"+"\\"+list1[i];
                String information;
                File f = new File(string);
                try{
                    FileReader inOne = new FileReader(f);
                    BufferedReader inTwo = new BufferedReader(inOne);
                    while((information = inTwo.readLine())!=null) {
                        area.append(information);
                        area.append("\n");
                    }
                }  catch(IOException exp){}
            }
        }
        list1 = file4.list();
        if(list1[1].equals(name)){
            for(int i = 0; i<2;i++){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\四号放映厅"+"\\"+list1[i];
                String information;
                File f = new File(string);
                try{
                    FileReader inOne = new FileReader(f);
                    BufferedReader inTwo = new BufferedReader(inOne);
                    while((information = inTwo.readLine())!=null) {
                        area.append(information);
                        area.append("\n");
                    }
                }  catch(IOException exp){}
            }
        }
        list1 = file5.list();
        if(list1[1].equals(name)){
            for(int i = 0; i<2;i++){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\五号放映厅"+"\\"+list1[i];
                String information;
                File f = new File(string);
                try{
                    FileReader inOne = new FileReader(f);
                    BufferedReader inTwo = new BufferedReader(inOne);
                    while((information = inTwo.readLine())!=null) {
                        area.append(information);
                        area.append("\n");
                    }
                }  catch(IOException exp){}
            }
        }
    }
}

class Ticket_sale extends JPanel {
    JLabel label1,label2,label3;
    JButton button;
    JTextField field1,field2,field3;
    JTextArea area;

    Ticket_sale(){
        setLayout(new FlowLayout());
        label1 = new JLabel("片名");
        label2 = new JLabel("场次");
        label3 = new JLabel("用户名或手机号");
        button = new JButton("确定");
        field1 = new JTextField(10);
        field2 = new JTextField(10);
        field3 = new JTextField(10);
        area = new JTextArea(20,30);
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(label3);
        add(field3);
        add(button);
        add(area);
    }
}



