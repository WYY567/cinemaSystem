import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class Manager extends JFrame implements ActionListener {
    JLabel label1;
    JLabel lable2;
    JTextField field1;
    JPasswordField field2;
    JButton button;
    String Account_number;
    String password;
    public Manager(){
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
        setTitle("经理登录");
        setVisible(true);
        setBounds(60,100,500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Account_number = field1.getText();
        password = field2.getText();
        Account_number = Account_number+".txt";
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\经理信息",Account_number);
        try{
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String str = inTwo.readLine();
            if(str.equals(password)){
                new Manager_function();
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

class Manager_function extends JFrame implements ActionListener{
    JMenuBar menubar;
    JMenu menu1,menu2,menu3;
    JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,menuItem5,menuItem6,menuItem7,menuItem8,menuItem9;

    Manager_function(){
        menubar = new JMenuBar();
        menu1 = new JMenu("菜单");
        menu2 = new JMenu("影片管理");
        menu3 = new JMenu("排片管理");
        menuItem1 = new JMenuItem("列出所有正在上映的影片信息");
        menuItem2 = new JMenuItem("添加影片信息");
        menuItem3 = new JMenuItem("修改电影信息");
        menuItem4 = new JMenuItem("删除影片信息");
        menuItem5 = new JMenuItem("查询影片信息");
        menuItem6 = new JMenuItem("增加场次");
        menuItem8 = new JMenuItem("删除场次");
        menuItem9 = new JMenuItem("列出所有场次信息");
        menubar.add(menu1);
        menu1.add(menu2);
        menu1.add(menu3);
        menu2.add(menuItem1);
        menu2.add(menuItem2);
        menu2.add(menuItem3);
        menu2.add(menuItem4);
        menu2.add(menuItem5);
        menu3.add(menuItem6);
        menu3.add(menuItem8);
        menu3.add(menuItem9);
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
        menuItem6.addActionListener(this);
        menuItem8.addActionListener(this);
        menuItem9.addActionListener(this);
        setJMenuBar(menubar);
        setLayout(new FlowLayout());
        setBounds(60,100,500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem1) {
            new List_movie_information();
        }
        else if(e.getSource() == menuItem2){
            new Add_movie_information();
        }
        else if(e.getSource() == menuItem3){
            new Modify_movie_information();
        }
        else if(e.getSource() == menuItem4){
            new Delete_movie_information();
        }
        else if(e.getSource() == menuItem5){
            new Query_video_information();
        }
        else if(e.getSource() == menuItem6){
            new Additional_sessions();
        }
        else if(e.getSource() == menuItem8){
            new delete();
        }
        else if(e.getSource() == menuItem9){
            new List_all_session_information();
        }
    }
}


class List_movie_information extends JFrame implements ActionListener{
    JTextArea area;
    JButton button;
    List_movie_information(){
        setLayout(new FlowLayout());
        button = new JButton("列出所有影片信息");
        area = new JTextArea(10,10);
        add(button);
        add(area);
        button.addActionListener(this);
        setBounds(60,100,800,700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

class Add_movie_information extends JFrame implements ActionListener{
    JButton button;
    JLabel label1,label2,label3,label4,label5;
    JTextField field1,field2,field3,field4,field5;

    Add_movie_information(){
        setLayout(new FlowLayout());
        button = new JButton("确定");
        label1 = new JLabel("片名");
        label2 = new JLabel("导演");
        label3 = new JLabel("主演");
        label4 = new JLabel("主要内容");
        label5 = new JLabel("影片时长");
        field1 = new JTextField(10);
        field2 = new JTextField(10);
        field3 = new JTextField(10);
        field4 = new JTextField(10);
        field5 = new JTextField(10);
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(label3);
        add(field3);
        add(label4);
        add(field4);
        add(label5);
        add(field5);
        add(button);
        field1.addActionListener(this);
        field2.addActionListener(this);
        field3.addActionListener(this);
        field4.addActionListener(this);
        field5.addActionListener(this);
        button.addActionListener(this);
        setBounds(60,100,200,300);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str1,str2,str3,str4,str5;
        str1 = field1.getText();
        str2 = field2.getText();
        str3 = field3.getText();
        str4 = field4.getText();
        str5 = field5.getText();
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电影信息",str1+".txt");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException exp){
                System.out.println(exp);
            }
        }
        try{
            FileWriter tofile = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(tofile);
            out.write("1.片名："+str1);
            out.newLine();
            out.write("2.导演："+str2);
            out.newLine();
            out.write("3.主演："+str3);
            out.newLine();
            out.write("4.剧情简介"+str4);
            out.newLine();
            out.write("5.时长"+str5);
            out.newLine();
            out.close();
            tofile.close();
            JOptionPane.showMessageDialog(null, "添加成功", "警告", JOptionPane.WARNING_MESSAGE);
        }
        catch(IOException exp){
            JOptionPane.showMessageDialog(null, "添加失败", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class Modify_movie_information extends JFrame implements ActionListener, ItemListener {
    JTextField field1;
    JComboBox choice;
    JTextField field;
    JLabel label;
    JButton button;
    String content;
    String choice1;
    String name;
    String fileContent = "";

    Modify_movie_information(){
        label = new JLabel("影片名");
        button = new JButton("确定");
        choice = new JComboBox<String>();
        field = new JTextField(15);
        field1 = new JTextField(15);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(60,100,350,350);
        String []select = {"选择要更改的部分","导演","主演","剧情简介","时长"};
        for(String str:select){
            choice.addItem(str);
        }
        add(label);
        add(field1);
        add(choice);
        add(field);
        add(button);
        button.addActionListener(this);
        choice.addItemListener(this);
        field.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        content = field.getText();
        name = field1.getText();
        File file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电影信息",name+".txt");
        if(file.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                String replace = null;
                char []words = null;
                while ((line = reader.readLine()) != null) {
                    words = line.toCharArray();
                    if(choice1.equals("导演")){
                        words = line.toCharArray();
                        if(words[0] == '2'){
                            content = "2.导演："+content;
                            replace = line;
                        }
                    }
                    else if(choice1.equals("主演")){
                        words = line.toCharArray();
                        if(words[0] == '3'){
                            content = "3.主演："+content;
                            replace = line;
                        }
                    }
                    else if(choice1.equals("剧情简介")){
                        words = line.toCharArray();
                        if(words[0] == '4'){
                            content = "4.剧情简介："+content;
                            replace = line;
                        }
                    }
                    else if(choice1.equals("时长")){
                        words = line.toCharArray();
                        if(words[0] == '5'){
                            content = "5.时长："+content;
                            replace = line;
                        }
                    }
                    fileContent += line + System.lineSeparator();
                }
                fileContent = fileContent.replaceAll(replace,content);
                // 写入文件
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(fileContent);
                }
                fileContent = "";
                JOptionPane.showMessageDialog(null, "修改成功", "警告", JOptionPane.WARNING_MESSAGE);
            }catch(IOException exp){
                JOptionPane.showMessageDialog(null, exp, "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "该电影不存在", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        choice1 = choice.getSelectedItem().toString();
    }
}

class Delete_movie_information extends JFrame implements ActionListener {
    JLabel label;
    JTextField field;
    JButton button;
    File file;
    String id;
    Delete_movie_information(){
        setLayout(new FlowLayout());
        label = new JLabel("请输入您要删除的电影的名字");
        field = new JTextField(15);
        button = new JButton("确认");
        add(label);
        add(field);
        add(button);
        field.addActionListener(this);
        button.addActionListener(this);
        setVisible(true);
        setBounds(100,200,300,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        id = field.getText();
        id = id + ".txt";
        file = new File("C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\电影信息",id);
        if(file.exists()){
            int n = JOptionPane.showConfirmDialog(null,"您确定要删除这部电影的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n == JOptionPane.YES_OPTION){
                file.delete();
                JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "该影片未删除", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "该电影不存在", "警告", JOptionPane.WARNING_MESSAGE);
        }


    }
}

class Query_video_information extends JFrame implements ActionListener {
    JLabel label;
    JButton button;
    JTextField field;
    JTextArea area;

    Query_video_information() {
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
        setVisible(true);
        setBounds(100, 200, 800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        }
        catch (IOException exp) {
            JOptionPane.showMessageDialog(null, exp, "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}

class Additional_sessions extends JFrame implements ActionListener,ItemListener{
    JLabel label1,label2,label3;
    JButton button;
    JTextField field1,field2,field3;
    JComboBox choice_screen_hall;

    String hall;
    String Screen_Hall,price,time,name;

    Additional_sessions(){
        setLayout(new FlowLayout());
        label1 = new JLabel("影片名字");
        label2 = new JLabel("时间段");
        label3 = new JLabel("价格");
        field1 = new JTextField(10);
        field2 = new JTextField(10);
        field3 = new JTextField(10);
        button = new JButton("确定");
        choice_screen_hall = new JComboBox();
        String []screen_hall = {"选择放映厅","一号放映厅","二号放映厅","三号放映厅","四号放映厅","五号放映厅"};
        for(String str:screen_hall){
            choice_screen_hall.addItem(str);
        }
        add(choice_screen_hall);
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(label3);
        add(field3);
        add(button);
        field1.addActionListener(this);
        field2.addActionListener(this);
        field3.addActionListener(this);
        button.addActionListener(this);
        choice_screen_hall.addItemListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0,0,200,300);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        name = field1.getText();
        time = field2.getText();
        price = field3.getText();
        int sure = 0;
        if(Screen_Hall.equals("一号放映厅")){
            hall = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\一号放映厅";
            sure = Set_the_movie_to_play(name,time,price);
            if(sure == 1){
                JOptionPane.showMessageDialog(null, "增加成功", "", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(Screen_Hall.equals("二号放映厅")){
            hall = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\二号放映厅";
            sure = Set_the_movie_to_play(name,time,price);
            if(sure == 1){
                JOptionPane.showMessageDialog(null, "增加成功", "", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(Screen_Hall.equals("三号放映厅")){
            hall = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\三号放映厅";
            sure = Set_the_movie_to_play(name,time,price);
            if(sure == 1){
                JOptionPane.showMessageDialog(null, "增加成功", "", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(Screen_Hall.equals("四号放映厅")){
            hall = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\四号放映厅";
            sure = Set_the_movie_to_play(name,time,price);
            if(sure == 1){
                JOptionPane.showMessageDialog(null, "增加成功", "", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(Screen_Hall.equals("五号放映厅")){
             hall = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\五号放映厅";
            sure = Set_the_movie_to_play(name,time,price);
            if(sure == 1){
                JOptionPane.showMessageDialog(null, "增加成功", "", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "增加失败", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public int Set_the_movie_to_play(String name, String time, String price) {
        String  path2 = hall + "\\" + name + ".txt";
        File file1 = new File(path2);
        int sure = 0;
        if (!file1.exists()) {
            try {
                file1.createNewFile();
                FileWriter tofile = new FileWriter(path2);
                BufferedWriter out = new BufferedWriter(tofile);
                out.write("时间:" + time);
                out.newLine();
                out.write("价格:" + price);
                out.close();
                sure = 1;
            } catch (IOException exp) {
                JOptionPane.showMessageDialog(null, exp, "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        return sure;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Screen_Hall = choice_screen_hall.getSelectedItem().toString();
    }
}

class delete extends JFrame implements ActionListener{
    JButton button = new JButton("确定");
    JTextField field = new JTextField(10);
    JLabel label = new JLabel("输入电影名字删除该放映信息");

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
    delete(){
        setLayout(new FlowLayout());
        setVisible(true);
        setBounds(60,100,500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(label);
        add(field);
        add(button);
        field.addActionListener(this);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = field.getText();
        name = name+".txt";
        list1 = file1.list();
        if(list1[1].equals(name)){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\一号放映厅"+"\\"+list1[1];
                String information;
                File f = new File(string);
            int n = JOptionPane.showConfirmDialog(null,"您确定要删除这部电影的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n == JOptionPane.YES_OPTION){
                f.delete();
                JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "未删除", "警告", JOptionPane.WARNING_MESSAGE);}
        }
        list1 = file2.list();
        if(list1[1].equals(name)){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\二号放映厅"+"\\"+list1[1];
                String information;
                File f = new File(string);
                f.delete();
            int n = JOptionPane.showConfirmDialog(null,"您确定要删除这个用户的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "未删除", "警告", JOptionPane.WARNING_MESSAGE);}
            }
        list1 = file3.list();
        if(list1[1].equals(name)){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\三号放映厅"+"\\"+list1[1];
                String information;
                File f = new File(string);
            int n = JOptionPane.showConfirmDialog(null,"您确定要删除这个用户的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n == JOptionPane.YES_OPTION){
                f.delete();
                JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "未删除", "警告", JOptionPane.WARNING_MESSAGE);}
            }
        list1 = file4.list();
        if(list1[1].equals(name)){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\四号放映厅"+"\\"+list1[1];
                String information;
                File f = new File(string);
            int n = JOptionPane.showConfirmDialog(null,"您确定要删除这个用户的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n == JOptionPane.YES_OPTION){
                f.delete();
                JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "未删除", "警告", JOptionPane.WARNING_MESSAGE);}
            }
        list1 = file5.list();
        if(list1[1].equals(name)){
                String string = "C:\\Users\\wangyanyue\\IdeaProjects\\Cinema\\五号放映厅"+"\\"+list1[1];
                String information;
                File f = new File(string);
            int n = JOptionPane.showConfirmDialog(null,"您确定要删除这个用户的信息吗？","确定",JOptionPane.YES_NO_CANCEL_OPTION);
            if(n == JOptionPane.YES_OPTION){
                f.delete();
                JOptionPane.showMessageDialog(null, "删除成功", "警告", JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "未删除", "警告", JOptionPane.WARNING_MESSAGE);}
        }
    }
}

class List_all_session_information extends JFrame implements ActionListener{
    JButton button = new JButton("确定");

    JTextArea area = new JTextArea(100,100);
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
    List_all_session_information(){
        setVisible(true);
        setLayout(new FlowLayout());
        setBounds(60,50,1000,1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(button);
        add(area);
        button.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        list1 = file1.list();
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
        list1 = file2.list();
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
        list1 = file3.list();
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
        list1 = file4.list();
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
        list1 = file5.list();
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
