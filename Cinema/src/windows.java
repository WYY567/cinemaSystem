import javax.swing.*;
import java.awt.*;

public class windows extends JFrame {
    public windows (){
        setLayout(new FlowLayout());
        setTitle("影院管理系统");
        JComboBox<String> comBox = new JComboBox<>();
        JLabel label0 = new JLabel("身份");
        add(label0);
        comBox.addItem("请选择身份");
        comBox.addItem("用户");
        comBox.addItem("前台");
        comBox.addItem("管理员");
        comBox.addItem("经理");
        add(comBox);;
        JButton botton = new JButton("确认");
        add(botton);
        OperatorListener operator = new OperatorListener();
        ComputerListener computer = new ComputerListener();
        operator.setWorkTogether(computer);
        operator.setJComboBox(comBox);
        comBox.addItemListener(operator);
        botton.addActionListener(computer);
    }
}






